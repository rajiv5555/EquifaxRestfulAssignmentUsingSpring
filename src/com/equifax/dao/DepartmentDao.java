/**
 * 
 */
package com.equifax.dao;

import java.util.List;

import com.equifax.entity.Department;

/**
 * @author M1027962
 *
 */
public interface DepartmentDao {
	
	public Department saveOrUpdateDepartment(Department department);
	
	public Department getDepartmentByUniqueId(String id);
	
	public List<Department> getAllDepartments();
	
   public	Department deleteDepartment(String id);
   
   public Department saveDepartmentData(Department department) ;

}
