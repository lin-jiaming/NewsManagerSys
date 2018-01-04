package com.newsmanagersys.dao;

import com.newsmanagersys.entity.Section;
import com.newsmanagersys.utils.PageBean;

import java.util.List;

/**
 * 新闻版块的Dao层接口类
 */
public interface ITbSectionDao {
    //添加版块
    public boolean addSection(Section section);

    //查询版块
    public List findSectionList(String hql);

    //修改版块
    public boolean updateSectionList(Section section);

    //根据Id查询版块
    public Section getSectionById(int id);

    //删除版块
    public  boolean deleteSection(Section section);

    //分页查询出新闻版块
    public List findSectionPageList(String hql, PageBean pageBean);
}
