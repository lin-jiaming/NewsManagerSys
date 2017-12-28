package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbSectionDao;
import com.newsmanagersys.entity.Section;
import com.newsmanagersys.utils.PageBean;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 新闻版块的Dao层接口实现类
 */
@Repository("sectionDao")
public class TbSectionDaoImpl extends BaseDao implements ITbSectionDao{
    //添加新闻版块
    @Override
    public boolean addSection(Section section) {
        try {
            getSession().save(section);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //查询新闻版块
    @Override
    public List findSectionList(String hql) {
        return getSession().createQuery(hql).list();
    }

    //修改新闻版块
    @Override
    public boolean deleteSection(Section section) {
        try {
            getSession().delete(section);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

//    分页查询出数据
    @Override
    public List findSectionPageList(String hql, PageBean pageBean) {
        Query query = getSession().createQuery(hql);
        //设置分页
        query.setFirstResult((pageBean.getCpage()-1)*pageBean.getShowNum());//从哪里开始查询
        query.setMaxResults(pageBean.getShowNum());//设置每页查询多少条
        List list=query.list();
        return list;
    }
}
