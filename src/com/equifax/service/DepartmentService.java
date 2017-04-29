package com.equifax.service;

import java.util.List;

import com.equifax.entity.Department;

public interface DepartmentService {
	
	public Department saveOrUpdateDepartment(Department department);
	
	public Department getDepartment(String id);
	
	public List<Department> getAllDepartment();

	public Department deleteDepartment(String id);
	
    public Department saveDepartmentData(Department department);

	

}
