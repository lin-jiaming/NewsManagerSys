package com.newsmanagersys.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 新闻管理系统之角色类
 */
@Entity
@Table(name="Tb_Role")
public class Role implements Serializable{
    private int rno;        //角色Id
    private String rname;   //角色姓名

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Role() {
    }

    public Role(int rno, String rname) {
        this.rno = rno;
        this.rname = rname;
    }
}
