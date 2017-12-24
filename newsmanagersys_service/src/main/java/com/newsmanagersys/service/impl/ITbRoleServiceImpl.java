package com.newsmanagersys.service.impl;

import com.newsmanagersys.dao.ITbRoleDao;
import com.newsmanagersys.service.ITbRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITbRoleServiceImpl implements ITbRoleService {
    //注入需要用到的roleDao
    @Resource(name="roleDao")
    public ITbRoleDao roleDao;

    @Override
    public List findRoleList() {
        return roleDao.findRoleList("from Role");
    }

    public void setRoleDao(ITbRoleDao roleDao) {
        this.roleDao = roleDao;
    }


}
