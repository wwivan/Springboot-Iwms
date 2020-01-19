package com.iwms.server.service;

import com.iwms.server.dao.RoleUserDao;
import com.iwms.server.entity.RoleUser;
import com.iwms.server.entity.SystemReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleUserService {
    @Autowired
    RoleUserDao roleUserDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addRoleUser(RoleUser roleUser){
        roleUser.setPassword(bCryptPasswordEncoder.encode(roleUser.getPassword()));
        roleUserDao.save(roleUser);
    }
    public List<RoleUser> findAll(){
       return roleUserDao.findAll();
    }
    public RoleUser findById(SystemReq req){
        String roleUserId = req.getRoleUserId();
        return roleUserDao.findById(roleUserId).get();
    }
    public RoleUser findByMobile(String mobile){
        return roleUserDao.findByMobile(mobile);
    }
    public void deleteById(SystemReq req){
        String roleUserId = req.getRoleUserId();
        roleUserDao.deleteById(roleUserId);
    }
    public void updateById(String id,RoleUser roleUser){
        roleUser.setId(id);
        RoleUser roleUser1 = roleUserDao.findById(id).get();
        if(roleUser1.getPassword().equals(roleUser.getPassword())){
            roleUserDao.save(roleUser);
        }else{
            roleUser.setPassword(bCryptPasswordEncoder.encode(roleUser.getPassword()));
            roleUserDao.save(roleUser);
        }
    }
}
