package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbUserDao;
import com.newsmanagersys.entity.Users;
import com.newsmanagersys.service.ITbUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务层接口接口实现类
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbUserServiceImpl implements ITbUserService{
    //注入需要用到的ITbUserDao接口类
    @Resource(name="userDao")
    private ITbUserDao userDao;

    //登录
    @Override
    public Users doLogin(Users user) {
        String hql ="from Users u where u.uname='"+user.getUname()+"' and u.ustate=1";
        //取出同名的所有用户
        List<Users> list = userDao.findUsersList(hql);
        if(list!=null&&list.size()>0){
            for (Users users : list) {
                if(users.getUname().equals(user.getUname())&&users.getUpwd().equals(user.getUpwd())){
                    return users;
                }
            }
        }
        return null;
    }
    //添加用户
    @Override
    public boolean addUsers(Users user) {
        return userDao.addUsers(user);
    }

    //修改用户
    @Override
    public boolean updateUsers(Users user) {
        return userDao.updateUsers(user);
    }

    //删除用户
    @Override
    public boolean deleteUsers(Users user) {
        return userDao.deleteUsers(user);
    }

    //查询用户
    @Override
    public List findUsersList() {
        return userDao.findUsersList("from Users u inner join u.role r where r.rno=2");
    }

    //根据Id查询用户
    @Override
    public Users getUsersById(int id) {
        return userDao.getUsersById(id);
    }

    //锁定用户
    @Override
    public boolean lockUpUser(int id) {
        Users user = userDao.getUsersById(id);
        user.setUstate(0);
        return userDao.updateUsers(user);
    }

    //解锁用户
    @Override
    public boolean lockDownUser(int id) {
        Users user = userDao.getUsersById(id);
        user.setUstate(1);
        return userDao.updateUsers(user);
    }

    //修改用户密码
    @Override
    public boolean updateUserPwd(int id,String upwd) {
        Users user=getUsersById(id);
        user.setUpwd(upwd);
        return userDao.updateUsers(user);
    }


    public void setUserDao(ITbUserDao userDao) {
        this.userDao = userDao;
    }

}
