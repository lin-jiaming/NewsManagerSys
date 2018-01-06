package com.newsmanagersys;

import com.newsmanagersys.entity.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    //用户实体类
    Users testUsers;
    //用户详细信息实体类
    UserInfo testUserInfo;
    //新闻实体类
    Section testSection;
    //新闻版块实体类
    News testNews;
    //角色实体类
    Role testRole;


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    //测试能否添加用户
    public void testSetUsers() throws Exception {
        testUsers = new Users(0,"test","test",1);
        System.out.println(testUsers);
    }

    //测试能否添加用户详细信息
    public void testSetUserInfo() throws Exception{
        testUserInfo = new UserInfo(1,"test", 20, "男", "testImage", "10086", "www.test@qq.com", "广东", new Date());
        System.out.println(testUserInfo);
    }
    //测试能否添加角色信息
    public void testSetRole() throws Exception{
        testRole = new Role(1,"测试人员");
        System.out.println(testRole);
    }
    //测试能否添加新闻版块信息
    public void testSetSection() throws Exception{
        testSection = new Section(1,"测试");
        System.out.println(testSection);
    }
    //测试能否添加新闻信息
    public void testSetNews() throws Exception{
        testNews  = new News(1,"测试","测试",new Date(),"测试","testImage");
        System.out.println(testNews);
    }



}
