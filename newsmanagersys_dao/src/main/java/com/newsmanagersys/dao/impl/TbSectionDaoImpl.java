package com.newsmanagersys.dao.impl;

import com.newsmanagersys.dao.ITbSectionDao;
import com.newsmanagersys.entity.Section;
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
    public boolean updateSection(Section section) {
        try {
            getSession().update(section);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
