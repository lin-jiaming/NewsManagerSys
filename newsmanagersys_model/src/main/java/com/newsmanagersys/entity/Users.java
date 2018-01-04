package com.newsmanagersys.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 新闻管理系统之用户表
 */
@Entity
@Table(name="Tb_User")
public class Users implements Serializable{
    private int uno;
    private String uname;   //用户账号
    private String upwd;        //用户密码
    private int ustate=1; //用户状态：0是已锁定，1是未锁定


    //多个用户对应一个角色
    private Role role;


    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name = "urno")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getUstate() {
        return ustate;
    }

    public void setUstate(int ustate) {
        this.ustate = ustate;
    }

    public Users(int uno, String uname, String upwd, int ustate) {
        this.uno = uno;
        this.uname = uname;
        this.upwd = upwd;
        this.ustate = ustate;
    }

    public Users() {
    }
}
