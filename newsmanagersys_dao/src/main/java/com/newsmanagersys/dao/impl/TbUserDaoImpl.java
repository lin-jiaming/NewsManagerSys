package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbUserDao;
import com.newsmanagersys.entity.Users;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao层接口实现类
 */
@Repository("userDao")
public class TbUserDaoImpl extends BaseDao implements ITbUserDao {
    //添加用户
    @Override
    public boolean addUsers(Users user) {
        try {
            getSession().save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //修改用户信息
    @Override
    public boolean updateUsers(Users user) {
        try {
            getSession().update(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //删除用户信息
    @Override
    public boolean deleteUsers(Users user) {
        try {
            getSession().delete(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //查询用户信息
    @Override
    public List findUsersList(String hql) {
        return getSession().createQuery(hql).list();
    }

    //根据Id查询信息
    @Override
    public Users getUsersById(int id) {
        return getSession().get(Users.class,id);
    }


}
