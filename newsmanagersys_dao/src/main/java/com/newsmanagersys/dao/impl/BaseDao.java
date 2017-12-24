package com.newsmanagersys.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 会话工具类
 */
@Repository
public class BaseDao {
    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
