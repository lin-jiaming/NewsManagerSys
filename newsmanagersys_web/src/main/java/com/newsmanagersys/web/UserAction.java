package com.newsmanagersys.web;

import com.newsmanagersys.entity.UserInfo;
import com.newsmanagersys.entity.Users;
import com.newsmanagersys.service.ITbRoleService;
import com.newsmanagersys.service.ITbUserInfoService;
import com.newsmanagersys.service.ITbUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户控制类
 */
@Controller
@RequestMapping("/userAction")
@Scope("prototype")
public class UserAction {
    //注入需要用到的Service接口
    @Resource(name = "roleService")
    private ITbRoleService roleService;
    @Resource(name = "userService")
    private ITbUserService userService;
    @Resource(name = "userInfoService")
    private ITbUserInfoService userInfoService;

    //去到添加用户的页面
    @RequestMapping("/toAddUser")
    public String toAddUser(Model model) {
        List roleList = roleService.findRoleList();
        model.addAttribute("roleList", roleList);
        return "pages/addUser";
    }

    //添加用户的方法
    @RequestMapping("/doAddUser")
    public String doAddUser(Users user, Model model) throws IOException {
        //调用服务层执行添加用户
        if (userService.addUsers(user)) {
            model.addAttribute("res", "1");
        } else {
            model.addAttribute("res", "-1");
        }
        return "redirect:/userAction/toAddUser";
    }

    //查询用户
    @RequestMapping("/findUserList")
    public String findUserList(Model model) {
        model.addAttribute("userList", userService.findUsersList());
        return "pages/userList";
    }

    //锁定用户
    @RequestMapping("/lockUpUser")
    public String lockUpUser(Users user, Model model) {
        //调用服务层执行锁定用户
        if (userService.lockUpUser(user.getUno())) {
            model.addAttribute("res", "1");
        } else {
            model.addAttribute("res", "1");
        }
        return "redirect:/userAction/findUserList";
    }

    //解锁用户
    @RequestMapping("/lockDownUser")
    public String lockDownUser(Users user, Model model) {
        //调用服务层执行解锁用户
        if (userService.lockDownUser(user.getUno())) {
            model.addAttribute("res", "1");
        } else {
            model.addAttribute("res", "1");
        }
        return "redirect:/userAction/findUserList";
    }

    //先根据Id查询出用户的详细信息
    @RequestMapping("/getUserInfoById")
    public String getUserInfoById(Users user, Model model) {
        List list = userInfoService.getUserInfoById(user.getUno());
        model.addAttribute("userinfo",list);
        return "pages/userInfo";
    }

    //添加用户详细信息
    @RequestMapping("/addUserInfo")
    public String addUserInfo(MultipartFile ufile, @Valid UserInfo userInfo, BindingResult result, Users user, HttpSession session, Model model) {
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //验证数据
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError err : list) {
                System.out.println(err.getCode() + ":" + err.getDefaultMessage());
            }
            return "pages/addUserInfo";
        }
    //判断是否有文件上上传
        if(!ufile.isEmpty()) {
            //获取服务器路径
            String basePath = session.getServletContext().getRealPath("/userimg");
            String realName = sdf.format(new Date()) + ":" + ufile.getOriginalFilename();   //设置文件名
            try {
                //执行文件上传
                ufile.transferTo(new File(basePath + "/" + realName));
                userInfo.setUsers(user);
                userInfo.setUimg(realName);    //设置用户的文件路径
                //调用服务层方法，修改用户详细信息
                if (userInfoService.addUserInfo(userInfo)) {
                    model.addAttribute("res", "1");
                } else {
                    model.addAttribute("res", "-1");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
            return"/userAction/getUserInfoById?uno="+userInfo.getUsers(). getUno();
}


    //先去到修改学生的页面
    @RequestMapping("/toUpdateUserInfo")
    public String toUpdateUserInfo(Users user,Model model){
        List list = userInfoService.getUserInfoById(user.getUno());
        model.addAttribute("userinfo",list);
        return "pages/updateUserInfo";
    }

    //执行修改用户详细信息的方法
    @RequestMapping("doUpdateUserInfo")
    public String doUpdateUserInfo(@Valid UserInfo uInfo, BindingResult result, Model model, MultipartFile ufile, Users user, HttpSession session){
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取外键Id
        user = userService.getUsersById(user.getUno());
        //验证数据
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError err : list) {
                System.out.println(err.getCode() + ":" + err.getDefaultMessage());
            }
            return "/userAction/toUpdateUserInfo?uno="+user.getUno();
        }
        //判断是否有文件上上传
        if(!ufile.isEmpty()) {
            //获取服务器路径
            String basePath = session.getServletContext().getRealPath("/userimg");
            String realName = sdf.format(new Date()) + ":" + ufile.getOriginalFilename();   //设置文件名
            try {
                //执行文件上传
                ufile.transferTo(new File(basePath + "/" + realName));
                uInfo.setUsers(user);
                uInfo.setUimg(realName);    //设置用户的文件路径
                //调用服务层方法，添加用户详细信息
                if (userInfoService.updateUserInfo(uInfo)) {
                    model.addAttribute("res", "1");
                } else {
                    model.addAttribute("res", "-1");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return"redirect:/userAction/getUserInfoById?uno="+uInfo.getUsers(). getUno();
    }

    //去到修改页面
    @RequestMapping("toUpdateUserPwd")
    public String toUpdateUserPwd(Users user){
        userService.getUsersById(user.getUno());
        return "pages/updateUserPwd";
    }

    //执行修改用户密码的方法
    @RequestMapping("doUpdateUserPwd")
    public String doUpdateUserPwd(Users user,String upwd,String newPwd,Model model) {
        //判断用户传过来的upwd是否为空
        if(upwd.equals(newPwd)&&user.getUpwd()!="") {
            //调用服务层修改用户密码
            if (userService.updateUserPwd(user.getUno(), upwd)) {
                //如果修改成功就返回登录页面
                return "pages/userlogin";
            }
        } else {
                model.addAttribute("res", "-1");
            }
        return "redirect:/userAction/toUpdateUserPwd";
    }
    public void setRoleService(ITbRoleService roleService) {
        this.roleService = roleService;
    }

    public void setUserService(ITbUserService userService) {
        this.userService = userService;
    }

    public void setUserInfoService(ITbUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}
