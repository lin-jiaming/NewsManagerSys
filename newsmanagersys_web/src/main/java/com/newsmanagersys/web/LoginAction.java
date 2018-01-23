package com.newsmanagersys.web;

import com.newsmanagersys.entity.Users;
import com.newsmanagersys.service.ITbUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户登录的Action
 */
@Controller
@RequestMapping("/loginAction")
@Scope("prototype")
public class LoginAction {
    //注入需要用到的userService
    @Resource(name="userService")
    private ITbUserService userService;

    @RequestMapping("/doLogin")
    public String doLogin(Users user, HttpSession session){
        user=userService.doLogin(user);
        if(user!=null){
            //登录成功，记录用户登录信息
            session.setAttribute("LoginUser",user);
        }else{
            //登录失败，提示用户
            session.setAttribute("message","用户名和密码不能为空!");
            return "pages/userlogin";
        }
        return "main";
    }

    public void setUserService(ITbUserService userService) {
        this.userService = userService;
    }
}
