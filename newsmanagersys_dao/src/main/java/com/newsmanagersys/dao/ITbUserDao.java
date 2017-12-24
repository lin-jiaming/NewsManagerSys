package com.newsmanagersys.dao;

import com.newsmanagersys.entity.Users;

import java.util.List;

/**
 * 用户Dao层接口类
 */
public interface ITbUserDao {
    //1:添加用户
    public boolean addUsers(Users user);
    //2:修改用户
    public boolean updateUsers(Users user);
    //3:删除用户
    public boolean deleteUsers(Users user);
    //4:查询用户
    public List findUsersList(String hql);
    //5:根据用户id查询
    public Users getUsersById(int id);
}
