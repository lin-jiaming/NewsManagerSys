package com.newsmanagersys.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 新闻管理系统之新闻版块
 */
@Entity
@Table(name="Tb_Section")
public class Section implements Serializable {
    private int sno;
    private String sname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Section(int sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public Section() {
    }
}
