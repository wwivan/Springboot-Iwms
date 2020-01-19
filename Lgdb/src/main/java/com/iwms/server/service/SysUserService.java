package com.iwms.server.service;

import com.iwms.server.dao.SysUserDao;
import com.iwms.server.entity.RoleUser;
import com.iwms.server.entity.SysUser;
import com.iwms.server.entity.SystemReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addSysUser(SysUser sysUser) {
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        sysUserDao.save(sysUser);
    }

    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    public SysUser findById(SystemReq req) {
        String sysUserId = req.getSysUserId();
        return sysUserDao.findById(sysUserId).get();
    }

    public SysUser findByName(String UserName) {
        return sysUserDao.findByUserName(UserName);
    }

    public void deleteById(SystemReq req) {
        String sysUserId = req.getSysUserId();
        sysUserDao.deleteById(sysUserId);
    }

    public void updateById(String id, SysUser sysUser) {
        sysUser.setId(id);
        SysUser sysUser1 = sysUserDao.findById(id).get();
        if (sysUser1.getPassword().equals(sysUser.getPassword())) {
            sysUserDao.save(sysUser);
        } else {
            sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
            sysUserDao.save(sysUser);
        }
    }

    public boolean login(SysUser req) {
        String userName = req.getUserName();
        SysUser sysUser = sysUserDao.findByUserName(userName);
        String password = req.getPassword();
        return bCryptPasswordEncoder.matches(password, sysUser.getPassword());
    }
}
