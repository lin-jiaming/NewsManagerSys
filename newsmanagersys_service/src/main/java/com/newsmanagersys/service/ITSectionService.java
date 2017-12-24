package com.newsmanagersys.service;

import com.newsmanagersys.entity.Section;

import java.util.List;

/**
 * 新闻版块的服务层接口类
 */
public interface ITSectionService {
    //添加新闻版块
    public boolean addSection(Section section);
    //修改新闻版块
    public boolean updateSection(Section section);
    //查询新闻版块
    public List findSectionList();
}
