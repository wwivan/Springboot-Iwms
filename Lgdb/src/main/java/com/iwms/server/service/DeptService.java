package com.iwms.server.service;

import com.iwms.server.dao.DeptDao;
import com.iwms.server.entity.Department;
import com.iwms.server.entity.SystemReq;
import com.iwms.server.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    /**
     * 增，列表，id查询，name查询，删除，更新
     * @param department
     */
    public void addDept(Department department){
        deptDao.save(department);
    }

    public List<Department> findAll(){
        List<Department> all = deptDao.findAll();
        return all;
    }
    public Department findById(SystemReq req){
        String deptId = req.getDeptId();
        Department department = deptDao.findById(deptId).get();
        return department;
    }
    public Department findByName(String deptName){
        Department departmentByDeptName = deptDao.findDepartmentByDeptName(deptName);
        return departmentByDeptName;
    }
    public void deleteById(SystemReq req){
        deptDao.deleteById(req.getDeptId());
    }
    public void updateById(String id, Department department){
        department.setId(id);
        deptDao.save(department);
    }
}
