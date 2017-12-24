package com.newsmanagersys.dao;

import java.util.List;

/**
 * 角色的Dao层接口类
 */
public interface ITbRoleDao {
    //查询角色
    public List findRoleList(String hql);
}
