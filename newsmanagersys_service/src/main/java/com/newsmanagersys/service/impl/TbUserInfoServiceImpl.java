package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbUserInfoDao;
import com.newsmanagersys.entity.UserInfo;
import com.newsmanagersys.service.ITbUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户详细信息服务层接口实现类
 */
@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbUserInfoServiceImpl implements ITbUserInfoService{
    //注入userInfoDao
    @Resource(name="userinfoDao")
    private ITbUserInfoDao userInfoDao;
    @Override
    public boolean addUserInfo(UserInfo userinfo) {
        return userInfoDao.addUserInfo(userinfo);
    }

    @Override
    public boolean updateUserInfo(UserInfo userinfo) {
        return userInfoDao.updateUserInfo(userinfo);
    }

    @Override
    public List getUserInfoById(int id) {
        return userInfoDao.getUserInfoById("from UserInfo f where f.users.uno="+id);
    }

    public void setUserInfoDao(ITbUserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

}
