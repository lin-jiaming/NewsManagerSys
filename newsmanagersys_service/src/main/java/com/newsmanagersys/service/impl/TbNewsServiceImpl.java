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
    public List findNewsList() {
        return newsDao.findNewsList("from News n inner join n.section and n.nintime desc");
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

    //不带条件的分页查询数据
    @Override
    public PageBean findNewsPageList(PageBean pageBean) {
        String hql = "from News s inner join s.section order by s.nintime desc";
        //执行查询获取当前页要显示的数据
        pageBean.setResult(sectionDao.findSectionPageList(hql, pageBean));
        //获取总的数据条数
        pageBean.setAllNum(sectionDao.findSectionList(hql).size());
        return pageBean;
    }

    /**
     *分页带条件查询学生信息
     * @param pageBean 封装了分页查询的基础条件,例如:1:当前页码，2:每页显示的数据量
     * @param querys  封装了查询条件，例如:标题，作者，版块，日期
     * @return   分页带条件查询后的信息，例如:总条数，总页数，当前页要显示的数据
     */
    @Override
    public PageBean findNewsPageList(PageBean pageBean, String[] querys) {
        String hql ="from News n inner join n.section s where 1=1 ";
        //带有条件
        if(querys!=null&&querys.length>0){
            //标题
            if(querys[0]!=null&&querys[0].length()>0){
                    hql +="and n.ntitle like '%"+querys[0]+"%'";
            }
            //作者
            if(querys[1]!=null&&querys[1].length()>0){
                    hql +="and n.nauthor='"+querys[1]+"'";
            }
            //版块
            if(querys[2]!=null&&querys[2].length()>0){
                    hql +="and s.sno="+querys[2];
            }
            //日期
            if(querys[3]!=null&&querys[3].length()>0){
                    hql +="and n.nintime='"+querys[3]+"'";
            }
            //最后排序
            hql+=" order by n.nintime desc";
            //执行查询获取当前页要显示的数据
            pageBean.setResult(sectionDao.findSectionPageList(hql, pageBean));
            //获取总的数据条数
            pageBean.setAllNum(sectionDao.findSectionList(hql).size());
            return pageBean;
        }
        return null;
    }

    @Override
    public PageBean findNewsPageListBySection(PageBean pageBean, int id) {
        String hql ="from News n inner join n.section s where 1=1 and s.sno ="+id+" order by n.nintime desc";
        //执行查询获取当前页要显示的数据
        pageBean.setResult(sectionDao.findSectionPageList(hql, pageBean));
        //获取总的数据条数
        pageBean.setAllNum(sectionDao.findSectionList(hql).size());
        return pageBean;
    }

    @Override
    public List<News> findNewsListToJson() {
        return newsDao.findNewsListToJson("from News s order by s.nintime desc");
    }


    public void setNewsDao(ITbNewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public void setSectionDao(ITbSectionDao sectionDao) {
        this.sectionDao = sectionDao;
    }
}
