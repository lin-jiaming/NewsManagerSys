package com.newsmanagersys.dao;

import com.newsmanagersys.entity.Section;

import java.util.List;

/**
 * 新闻版块的Dao层接口类
 */
public interface ITbSectionDao {
    //添加版块
    public boolean addSection(Section section);

    //查询版块
    public List findSectionList(String hql);

    //删除版块
    public  boolean updateSection(Section section);
}
