/**
 * 
 */
package com.equifax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1027962
 *
 */
@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	

	@Column
	private String empUniqueId;
	
	@Column
	private String empName;

    @Column	
	private String technology;
	
    @Column
	private String phoneNumber;
	
    @Column
	private String emailAddress;
    
   
   /* @ManyToOne
    @JoinColumn(name="depId")
    private Department department; */
    

	public Employee() {
		
		
	}

	public Employee(int empId, String empName, String technology,
			String phnumber, String email,String empUniqueId ) {
		this.empId = empId;
		this.empUniqueId=empUniqueId;
		this.empName = empName;
		this.technology = technology;
		this.phoneNumber = phnumber;
		this.emailAddress = email;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmpUniqueId() {
		return empUniqueId;
	}

	public void setEmpUniqueId(String empUniqueId) {
		this.empUniqueId = empUniqueId;
	}
	
	
	
/*
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}*/

	
	

}
