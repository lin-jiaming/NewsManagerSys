package com.newsmanagersys.service;

import com.newsmanagersys.entity.UserInfo;

import java.util.List;

/**
 * 用户详细信息服务层
 */
public interface ITbUserInfoService {
    //添加用户信息
    public boolean addUserInfo(UserInfo usernfo);

    //修改用户信息
    public  boolean updateUserInfo(UserInfo userinfo);

    //根据Id查询出用户详细信息
    public List getUserInfoById(int id);

}
