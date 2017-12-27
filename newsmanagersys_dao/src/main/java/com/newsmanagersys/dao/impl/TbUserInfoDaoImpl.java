package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbUserInfoDao;
import com.newsmanagersys.entity.UserInfo;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户详细信息Dao层接口实现类
 */
@Repository("userinfoDao")
public class TbUserInfoDaoImpl extends BaseDao implements ITbUserInfoDao {
    @Override
    public boolean addUserInfo(UserInfo userinfo) {
        try {
            getSession().save(userinfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUserInfo(UserInfo userinfo) {
        try {
            getSession().update(userinfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public List getUserInfoById(String hql) {
        return getSession().createQuery(hql).list();
    }

}
