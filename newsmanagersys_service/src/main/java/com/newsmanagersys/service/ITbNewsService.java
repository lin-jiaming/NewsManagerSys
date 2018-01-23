package com.newsmanagersys.service;

import com.newsmanagersys.entity.News;
import com.newsmanagersys.utils.PageBean;

import java.util.List;

/**
 * 新闻Service层接口类
 */
public interface ITbNewsService {
    //添加新闻
    public  boolean addNews(News news);
    //查询新闻
    public List findNewsList();
    //修改新闻
    public boolean updateNews(News news);
    //删除新闻
    public boolean deleteNews(News news);
    //根据ID查询新闻
    public News getNewsById(int id);
    //分页查询出新闻
    public PageBean findNewsPageList(PageBean pageBean);
    //带条件的分页查询新闻
    public PageBean findNewsPageList(PageBean pageBean,String [] querys);
    //根据版块Id分页查询出新闻
    public PageBean findNewsPageListBySection(PageBean pageBean,int id);
}

