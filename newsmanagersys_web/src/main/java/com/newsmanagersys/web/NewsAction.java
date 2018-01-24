package com.newsmanagersys.web;

import com.newsmanagersys.entity.News;
import com.newsmanagersys.entity.Section;
import com.newsmanagersys.service.ITSectionService;
import com.newsmanagersys.service.ITbNewsService;
import com.newsmanagersys.utils.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //去到添加新闻页面
    @RequestMapping("toAddNews")
    public String toAddNews(Model model){
        //先获取到新闻版块
        List sectionList = sectionService.findSectionList();
        model.addAttribute("sectionList",sectionList);
        return "pages/addNews";
    }

    @RequestMapping("doAddNews")
    //执行添加
    public String doAddNews(MultipartFile sfile, News news, HttpSession session, Model model){
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //判断是否有文件上上传
        if(!sfile.isEmpty()) {
            //获取服务器路径
            String basePath = session.getServletContext().getRealPath("/newsImages");
            String realName = sdf.format(new Date()) + ":" + sfile.getOriginalFilename();   //设置文件名
            try {
                //执行文件上传
                sfile.transferTo(new File(basePath + "/" + realName));
                news.setNimages(realName);    //将上传到的图片路径保存到新闻的nimages字段中
                //调用服务层方法，添加新闻详细信息
                if (newsService.addNews(news)) {
                    model.addAttribute("res", "1");
                } else {
                    model.addAttribute("res", "-1");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
       return "redirect:/newsAction/toAddNews";
    }

    //先查询所有的新闻信息
    @RequestMapping("doFindNewsPageList")
    public String doFindNewsPageList(PageBean pageBean,Model model){
        //调用不带条件的查询新闻方法
        pageBean = newsService.findNewsPageList(pageBean);
        //调用查询新闻版块的方法
        toAddNews(model);
        return "pages/newsList";
    }


    @RequestMapping("doFindNewsPageForondition")
    //条件查询新闻
    public String doFindNewsPageForondition(PageBean pageBean,Model model){
        //调用带条件查询的Service层方法
         pageBean=newsService.findNewsPageList(pageBean,pageBean.getQuerys());
        //调用查询新闻版块的方法
        toAddNews(model);
        return "pages/newsList";
    }

    @RequestMapping("getNewsById")
    @ResponseBody
    //通过Id查询新闻详细信息
    public News getNewsById(News news){
        return newsService.getNewsById(news.getNno());
    }

    @RequestMapping("toUpdateNews")
    //去到修改新闻页面
    public  String  toUpdateNews(News news,Model model){
        news = newsService.getNewsById(news.getNno());
        model.addAttribute("news",news);
        model.addAttribute("secList",sectionService.findSectionList());
        return "pages/updateNews";
    }

    //执行修改新闻
    @RequestMapping("doUpdateNews")
    public String doUpdateNews(MultipartFile sfile, News news, HttpSession session,Model model){
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //判断是否有文件上上传
        if(!sfile.isEmpty()) {
            //获取服务器路径
            String basePath = session.getServletContext().getRealPath("/newsImages");
            String realName = sdf.format(new Date()) + ":" + sfile.getOriginalFilename();   //设置文件名
            try {
                //执行文件上传
                sfile.transferTo(new File(basePath + "/" + realName));
                news.setNimages(realName);    //将上传到的图片路径保存到新闻的nimages字段中
                //调用服务层方法，修改新闻详细信息
                if (newsService.updateNews(news)) {
                    model.addAttribute("res", "1");
                } else {
                    model.addAttribute("res", "-1");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        return "redirect:/newsAction/doFindNewsPageList";
    }

    //执行删除新闻
    @RequestMapping("doDeleteNews")
    public String doDeleteNews(News news,Model model){
        //调用服务层方法，删除新闻详细信息
        if (newsService.updateNews(news)) {
            model.addAttribute("res", "1");
        } else {
            model.addAttribute("res", "-1");
        }
        return "redirect:/newsAction/doFindNewsPageList";
    }

    //下载新闻图片
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fileName, HttpSession session) throws Exception {
        if(fileName!=null){
            //获取要下载的文件路径
            String basePath=session.getServletContext().getRealPath("/newsImages");
            String filePath=basePath+"/"+fileName;
            File outFile=new File(filePath);
            if(outFile.exists()){//要下载的文件是存在的
                HttpHeaders headers=new HttpHeaders();//构建一个头文件对象
                //设置文件以下载方式打开
                headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
                //设置文件类型
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)),headers, HttpStatus.OK);
            }
        }
        return null;
    }

    //查询出所有的新闻
    @RequestMapping("/doFindNewsList")
    public String doFindNewsList(PageBean pageBean){
        //调用不带条件的查询新闻方法
        pageBean = newsService.findNewsPageList(pageBean);
        return "newsList";
    }

    //根据Id查询出所属新闻的信息
    @RequestMapping("/doGetNewsById")
    public String doGetNewsById(News news,Model model){
        model.addAttribute("newsInfo",newsService.getNewsById(news.getNno()));
        return "newsInfo";
    }

    //根据版块Id分类出新闻
    @RequestMapping("/dofindNewsPageListBySection")
    public String dofindNewsPageListBySection(PageBean pageBean,Section section){
        //调用根据版块Id查询新闻的方法
        pageBean = newsService.findNewsPageListBySection(pageBean,section.getSno());
        return "newsList";
    }

    //Json数据
    @RequestMapping("/doFindNewsJson")
    @ResponseBody
    public List<News> doFindNewsJson(){
        List list = newsService.findNewsListToJson();
        return list;
    }

    public void setNewsService(ITbNewsService newsService) {
        this.newsService = newsService;
    }

    public void setSectionService(ITSectionService sectionService) {
        this.sectionService = sectionService;
    }
}
