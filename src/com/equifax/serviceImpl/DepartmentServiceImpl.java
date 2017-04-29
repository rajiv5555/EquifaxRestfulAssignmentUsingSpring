/**
 * 
 */
package com.equifax.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.dao.DepartmentDao;
import com.equifax.entity.Department;
import com.equifax.service.DepartmentService;

/**
 * @author M1027962
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public Department saveOrUpdateDepartment(Department department) {
		Department depart=null;
		depart=departmentDao.saveOrUpdateDepartment(department);
		if(null != depart)
		return depart;
		else return null;
	}
	
 public Department saveDepartmentData(Department department){
	 Department depart=null;
	
		depart=departmentDao.saveDepartmentData(department);
		if(null != depart)
		return depart;
	
		else return null;
	 
 }

	@Override
	public Department getDepartment(String id) {
		Department depart=null;
		depart=this.departmentDao.getDepartmentByUniqueId(id);
		if(null != depart)
			return depart;
			else return null;
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> departments=null;
		departments=this.departmentDao.getAllDepartments();
		if(departments.size()>0) return departments;
		else return null;
	}
	
	@Override
	public Department deleteDepartment(String id) {
		Department department=null;
		department=this.departmentDao.deleteDepartment(id);
		if(null!=department)
		return department;
		else return null;
	}

}
