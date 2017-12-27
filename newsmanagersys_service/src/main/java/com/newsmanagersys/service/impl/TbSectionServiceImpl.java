package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbSectionDao;
import com.newsmanagersys.entity.Section;
import com.newsmanagersys.service.ITSectionService;
import com.newsmanagersys.utils.PageBean;
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

    //分页查询出新闻版块
    @Override
    public PageBean findSectionPageList(PageBean bean) {
        String hql = "from Section";
        //执行查询获取当前页要显示的数据
        bean.setResult(sectionDao.findSectionPageList(hql, bean));
        //获取总的数据条数
        bean.setAllNum(sectionDao.findSectionList(hql).size());
        return null;
    }




    public void setSectionDao(ITbSectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }
}
