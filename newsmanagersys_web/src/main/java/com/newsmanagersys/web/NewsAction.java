package com.newsmanagersys.web;

import com.newsmanagersys.service.ITSectionService;
import com.newsmanagersys.service.ITbNewsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作新闻的控制类
 */
@Controller
@RequestMapping("/newsAction")
@Scope("prototype")
public class NewsAction {
    //注入需要用到的Dao层接口
    @Resource(name="newsService")
    private ITbNewsService newsService;
    @Resource(name="sectionService")
    private ITSectionService sectionService;

    //去到添加
    @RequestMapping("toAddNews")
    public String toAddNews(Model model){
        //先获取到新闻版块
        List sectionList = sectionService.findSectionList();
        model.addAttribute("sectionList",sectionList);
        return "pages/addNews";
    }
    public void setNewsService(ITbNewsService newsService) {
        this.newsService = newsService;
    }

    public void setSectionService(ITSectionService sectionService) {
        this.sectionService = sectionService;
    }
}
