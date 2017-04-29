/**
 * 
 */
package com.equifax.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.equifax.Exception.DepartmentNotFoundException;
import com.equifax.Exception.ErrorResponse;
import com.equifax.entity.Department;
import com.equifax.service.DepartmentService;

/**
 * @author M1027962
 *
 */

@RestController
public class DriverController {
	
	
/*	
 {
	      "depUniqueid":"5500",
		 "depName": "BFSI",
		 "employees" :[{
			"empUniqueId":"1000",
			"empName":"rajiv",
			"technology": "Java/j2ee",
			"phoneNumber" :"90097653",
			"emailAddress": "rajiv@yahoo.co.in"
		},{
			"empUniqueId":"1001",
			"empName":"ranjan",
			"technology": "Java",
			"phoneNumber" :"87925985567",
			"emailAddress": "ranjan@yahoo.co.in"
		}

		] }
  */
	

	
	@Autowired
	private DepartmentService departmentService;

	
	
	
	@RequestMapping(value="/Department/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Department getDepartment(@PathVariable(value="id") String id){
		Department department=null;
		department=departmentService.getDepartment(id);
		if(null==department){
			throw new DepartmentNotFoundException("Department with Id not found");
		}
		return department;
	}
	
	@RequestMapping(value="/Departments",method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getAllDepartment(){
		List<Department> departments=null;
		departments=departmentService.getAllDepartment();
		if(departments.size()==0){
			throw new DepartmentNotFoundException("No record found");
		}
		return departments;
	}
	
	@RequestMapping(value="/saveDepartmentdata",method=RequestMethod.POST)
	public ResponseEntity saveDepartmentdata(@RequestBody Department department){
		Department dep=null;
		dep=departmentService.saveDepartmentData(department);
		if(null ==dep){
			throw new PersistenceException("Department with "+department.getDepUniqueid()+" id already exist");
		}
		return  ResponseEntity.ok("Department data "+ department.getDepUniqueid() +" successfully saved !!!");
		
	}
	
	@RequestMapping(value="/updateDepartmentdata",method=RequestMethod.PUT)
	public ResponseEntity updateDepartmentdata(@RequestBody Department department){
		departmentService.saveOrUpdateDepartment(department);
		return ResponseEntity.ok("Department data "+ department.getDepUniqueid() +" successfully updated !!!");
	}

	@RequestMapping(value="/deleteDepartmentdata/{id}",method=RequestMethod.DELETE)
	public ResponseEntity deleteDepartmentdata(@PathVariable(value="id") String id){
		Department dep=null;
		dep=departmentService.deleteDepartment(id);
		if(dep==null) {
			throw new StaleStateException("Department with "+id+" id not found");
		}
		return ResponseEntity.ok("Depeartment data with "+id+" successfully deleated !!!");
	}
	
	
	@ExceptionHandler({DepartmentNotFoundException.class,StaleStateException.class})
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	} 
	
	@ExceptionHandler(PersistenceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler1(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setStatuscode(HttpStatus.CONFLICT.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	} 
	
	
}
