package com.newsmanagersys.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户详细信息表
 */
@Entity
@Table(name="Tb_UserInfo")
public class UserInfo implements Serializable {
    private int fno;
    @Length(min = 1,message ="真实姓名不能为空!" )
    private String urealname;   //真实姓名
    @Range(min= 18,max= 60,message = "年龄必须大于18小于60")
    private int uage;           //用户年龄
    private String usex;        //用户性别
    private String uimg;        //用户图像
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message = "手机号码格式不正确!")
    private String utel;        //联系号码
    @Email(message = "邮箱格式不正确")
    private String uemail;      //用户邮箱
    private String uaddree;     //用户地址
    private Date ucreatetime;       //用户注册日期

    //一个用户详细表对应一个用户
    private Users users;

    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name="funo")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public String getUrealname() {
        return urealname;
    }

    public void setUrealname(String urealname) {
        this.urealname = urealname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUaddree() {
        return uaddree;
    }

    public void setUaddree(String uaddree) {
        this.uaddree = uaddree;
    }

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    public Date getUcreatetime() {
        return ucreatetime;
    }

    public void setUcreatetime(Date ucreatetime) {
        this.ucreatetime = ucreatetime;
    }

    public UserInfo(int fno, String urealname, int uage, String usex, String uimg, String utel, String uemail, String uaddree, Date ucreatetime) {
        this.fno = fno;
        this.urealname = urealname;
        this.uage = uage;
        this.usex = usex;
        this.uimg = uimg;
        this.utel = utel;
        this.uemail = uemail;
        this.uaddree = uaddree;
        this.ucreatetime = ucreatetime;
    }

    public UserInfo() {
    }
}
