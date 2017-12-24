package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbSectionDao;
import com.newsmanagersys.entity.Section;
import com.newsmanagersys.service.ITSectionService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.naming.Name;
import java.util.List;

/**
 * 新闻版块的服务层接口实现类
 */
@Repository("sectionService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbSectionServiceImpl implements ITSectionService{
    //注入新闻Dao层接口
    @Resource(name="sectionDao")
    private ITbSectionDao sectionDao;
    //添加新闻版块
    @Override
    public boolean addSection(Section section) {
        return sectionDao.addSection(section);
    }

    //修改新闻版块
    @Override
    public boolean updateSection(Section section) {
        return sectionDao.updateSection(section);
    }

    //查询新闻版块
    @Override
    public List findSectionList() {
        return sectionDao.findSectionList("from Section");
    }

    public void setSectionDao(ITbSectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }
}
