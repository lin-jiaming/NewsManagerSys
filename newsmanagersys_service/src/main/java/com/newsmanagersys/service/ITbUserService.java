package com.newsmanagersys.service;

import com.newsmanagersys.entity.Users;

import java.util.List;

/**
 * 用户服务层接口类
 */
public interface ITbUserService {
    //1:用户登录
    public Users doLogin(Users user);
    //2:添加用户
    public boolean addUsers(Users user);
    //3:修改用户
    public boolean updateUsers(Users user);
    //4:删除用户
    public boolean deleteUsers(Users user);
    //5:查询用户
    public List findUsersList();
    //6:根据用户id查询
    public Users getUsersById(int id);
    //7:锁定用户
    public boolean lockUpUser(int id);
    //8:解锁用户
    public boolean lockDownUser(int id);
    //9:修改用户密码
    public boolean updateUserPwd(int id,String upwd);

}
