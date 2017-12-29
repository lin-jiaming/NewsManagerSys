package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbNewsDao;
import com.newsmanagersys.dao.ITbSectionDao;
import com.newsmanagersys.entity.News;
import com.newsmanagersys.service.ITbNewsService;
import com.newsmanagersys.utils.PageBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository("newsService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbNewsServiceImpl implements ITbNewsService {
    //注入需要用到的Dao层接口
    @Resource(name="newsDao")
    private ITbNewsDao newsDao;
    @Resource(name="sectionDao")
    private ITbSectionDao sectionDao;
    //添加新闻
    @Override
    public boolean addNews(News news) {
        return newsDao.addNews(news);
    }

    //查询新闻
    @Override
    public List findNewsList(String hql) {
        hql = "from News n inner join n.section";
        return newsDao.findNewsList(hql);
    }

    //修改新闻
    @Override
    public boolean updateNews(News news) {
        return newsDao.updateNews(news);
    }

    //删除新闻
    @Override
    public boolean deleteNews(News news) {
        return newsDao.deleteNews(news);
    }

    //根据Id查询
    @Override
    public News getNewsById(int id) {
        return newsDao.getNewsById(id);
    }

    //分页查询数据
    @Override
    public PageBean findNewsPageList(PageBean pageBean) {
        String hql = "from News s inner join s.section";
        //执行查询获取当前页要显示的数据
        pageBean.setResult(sectionDao.findSectionPageList(hql, pageBean));
        //获取总的数据条数
        pageBean.setAllNum(sectionDao.findSectionList(hql).size());
        return pageBean;
    }

    public void setNewsDao(ITbNewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public void setSectionDao(ITbSectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }
}
