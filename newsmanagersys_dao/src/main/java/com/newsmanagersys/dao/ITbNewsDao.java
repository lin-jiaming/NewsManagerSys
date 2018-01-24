package com.newsmanagersys.dao;

import com.newsmanagersys.entity.News;
import com.newsmanagersys.utils.PageBean;

import java.util.List;

/**
 * 新闻Dao层接口
 */
public interface ITbNewsDao {
    //添加新闻
    public  boolean addNews(News news);
    //查询新闻
    public List findNewsList(String hql);
    //修改新闻
    public boolean updateNews(News news);
    //删除新闻
    public boolean deleteNews(News news);
    //根据ID查询新闻
    public News getNewsById(int id);
    //泛型查询新闻Json格式
    public List<News> findNewsListToJson(String hql);
}
