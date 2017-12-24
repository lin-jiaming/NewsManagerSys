package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbRoleDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色的Dao层接口实现类
 */
@Repository("roleDao")
public class TbRoleDaoImpl extends BaseDao implements ITbRoleDao {
    @Override
    public List findRoleList(String hql) {
        return getSession().createQuery(hql).list();
    }
}
