package com.newsmanagersys.web;

import com.newsmanagersys.utils.PageBean;
import com.newsmanagersys.entity.Section;
import com.newsmanagersys.service.ITSectionService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String doFindSectionList(PageBean pageBean){
        //调用服务层方法执行分页带条件查询
        pageBean=sectionService.findSectionPageList(pageBean);
        return "pages/sectionList";
    }

    //删除新闻版块的方法
    @RequestMapping("/doDeleteSection")
    public String doDeleteSection(Section section,Model model){
        if(sectionService.deleteSection(section)){
            model.addAttribute("res","1");
        }else{
            model.addAttribute("res","-1");
        }
        return "redirect:/sectionAction/doFindSectionList";
    }

    //弹出修改新闻版块的对话框
    @RequestMapping("toUpdateSection")
    @ResponseBody
    public Section toUpdateSection(Section section){
        return sectionService.getSectionById(section.getSno());
    }

    @RequestMapping("doUpdateSection")
    //执行修改
    public String doUpdteSection(Section section,Model model){
        if(sectionService.updateSectionList(section)){
            model.addAttribute("res","1");
        }else{
            model.addAttribute("res","-1");
        }
        return  "redirect:/sectionAction/doFindSectionList";
    }

    //查询出所有版块的方法
    @RequestMapping("/dofindAllSectionList")
    @ResponseBody
    public List dofindAllSectionList(){
        List list =  sectionService.findSectionList();
        return list;
    }

    public void setSectionService(ITSectionService sectionService) {
        this.sectionService = sectionService;
    }

}
