package com.newsmanagersys.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 新闻管理系统之新闻类
 */
@Entity
@Table(name="Tb_News")
public class News implements Serializable {
    private int nno;
    private String ntitle; //新闻标题
    private String ncontent;  //新闻内容
    private Date nintime;   //编写时间
    private String nauthor;  //编写作者
    private String nimages;   //新闻图片


    //多个新闻对应一个版块
    private Section section;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name="nsno")
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getNno() {
        return nno;
    }

    public void setNno(int nno) {
        this.nno = nno;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    @Column(length = 9999)
    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getNintime() {
        return nintime;
    }

    public void setNintime(Date nintime) {
        this.nintime = nintime;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public String getNimages() {
        return nimages;
    }

    public void setNimages(String nimages) {
        this.nimages = nimages;
    }

    public News() {
    }

    public News(int nno, String ntitle, String ncontent, Date nintime, String nauthor, String nimages) {
        this.nno = nno;
        this.ntitle = ntitle;
        this.ncontent = ncontent;
        this.nintime = nintime;
        this.nauthor = nauthor;
        this.nimages = nimages;
    }
}
