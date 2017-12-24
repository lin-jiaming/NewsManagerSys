package com.newsmanagersys.dao;

import com.newsmanagersys.entity.UserInfo;

import java.util.List;

/**
 * 用户详细信息的Dao层接口类
 */
public interface ITbUserInfoDao {
    //添加用户信息
    public boolean addUserInfo(UserInfo userinfo);

    //修改用户信息
    public  boolean updateUserInfo(UserInfo userinfo);

    //根据外键查询出用户详细信息
    public List getUserInfoById(String hql);
}
