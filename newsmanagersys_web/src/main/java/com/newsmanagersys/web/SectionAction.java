package com.newsmanagersys.web;

import com.newsmanagersys.entity.Section;
import com.newsmanagersys.service.ITSectionService;
import com.newsmanagersys.utils.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理新闻版块的Action
 */
@Controller
@RequestMapping("/sectionAction")
@Scope("prototype")
public class SectionAction {
    @Resource(name="sectionService")
    //注入需要用到的Service接口类
    private ITSectionService sectionService;

    //添加新闻版块的方法
    @RequestMapping("/doAddSection")
    public String doAddSection(Section section, Model model){
        if(sectionService.addSection(section)){
            model.addAttribute("res","1");
        }else{
            model.addAttribute("res","-1");
        }
        return "redirect:/pages/addSection.jsp";
    }

    //查询出新闻版块的方法
    @RequestMapping("/doFindSectionList")
    public String doFindSectionList(PageBean pageBean, Model model){
        //调用服务层方法执行分页带条件查询
        pageBean=sectionService.findSectionPageList(pageBean);
        model.addAttribute("sectionList",pageBean);
        return "pages/sectionList";
    }

    public void setSectionService(ITSectionService sectionService) {
        this.sectionService = sectionService;
    }
}
