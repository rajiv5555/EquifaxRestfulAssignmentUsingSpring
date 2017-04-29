/**
 * 
 */
package com.equifax.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author M1027962
 *
 */
@Entity
@Table
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int depId;
	

	@Column
	private String depUniqueid;
	
	@Column
	private String depName;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Employee> employees;
	
	

	public Department(int depId, String depName,String depUniqueid, List<Employee> emp) {
		
		this.depId = depId;
		this.depUniqueid=depUniqueid;
		this.depName = depName;
		this.employees = emp;
	}

	public Department() {
		
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getDepUniqueid() {
		return depUniqueid;
	}

	public void setDepUniqueid(String depUniqueid) {
		this.depUniqueid = depUniqueid;
	}
	

	
}
