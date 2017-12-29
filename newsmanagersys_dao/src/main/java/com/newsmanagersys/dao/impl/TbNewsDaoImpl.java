package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbNewsDao;
import com.newsmanagersys.entity.News;
import com.newsmanagersys.utils.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 新闻Dao层的实现接口类
 */
@Repository("newsDao")
public class TbNewsDaoImpl extends BaseDao implements ITbNewsDao{
    @Override
    //添加新闻
    public boolean addNews(News news) {
        try {
            getSession().save(news);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //查询新闻
    @Override
    public List findNewsList(String hql) {
        return getSession().createQuery(hql).list();
    }

    //修改新闻
    @Override
    public boolean updateNews(News news) {
        try {
        getSession().update(news);
        return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //删除新闻
    @Override
    public boolean deleteNews(News news) {
        try {
        getSession().delete(news);
        return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    //根据Id查询新闻
    @Override
    public News getNewsById(int id) {
        return getSession().get(News.class,id);
    }

}
