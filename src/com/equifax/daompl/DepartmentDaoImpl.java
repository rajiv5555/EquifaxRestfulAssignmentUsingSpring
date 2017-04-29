/**
 * 
 */
package com.equifax.daompl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.equifax.Exception.DepartmentNotFoundException;
import com.equifax.dao.DepartmentDao;
import com.equifax.entity.Department;
import com.equifax.entity.Employee;


/**
 * @author M1027962
 *
 */
@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Department saveOrUpdateDepartment(Department department) {
		Session session=null;
		try{
		session=this.sessionFactory.openSession();
		Department dept=this.getDepartmentByUniqueId(department.getDepUniqueid());
		if(null !=dept){
			
			dept.setDepName(department.getDepName());
			for(Employee e:department.getEmployees()){
				 for(Employee e1:dept.getEmployees()){
					 if(e1.getEmpUniqueId().equals(e.getEmpUniqueId())){
						 e1.setEmailAddress(e.getEmailAddress());
						 e1.setEmpName(e.getEmpName());
						 e1.setPhoneNumber(e.getPhoneNumber());
						 e1.setTechnology(e.getTechnology());
					 }
				 }
			}
			session.update(dept);
		}else{
			session.save(department);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
			
		}
		return department;
	}
	
	

	public Department getDepartmentByUniqueId(String depUniqueId) {
		Session session=null;
		try{
			session =sessionFactory.openSession();
			String query="from Department d where d.depUniqueid=:depUniqueid";
			Query query2=session.createQuery(query);
			query2.setString("depUniqueid",depUniqueId);
			List result=query2.list();
			if(result.size()>0){
				return (Department) query2.list().get(0);
			}
			else return null;
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
				
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String query="from Department";
			Query q=(Query) session.createQuery(query);
			if(null != q)
			return q.list();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public Department deleteDepartment(String id) {
		Session session=null;
		Department department=null;
		try{
			session=sessionFactory.openSession();
			department=this.getDepartmentByUniqueId(id);
			if(null!=department)
			session.delete(department);
			else return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		
		return department;
	}



	@Override
	public Department saveDepartmentData(Department department) throws DepartmentNotFoundException{
		Session session=null;
		try{
		session=this.sessionFactory.openSession();
		Department dept=this.getDepartmentByUniqueId(department.getDepUniqueid());
		if(null !=dept){
			return null;
		}else{
			session.save(department);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
			
		}
		return department;
	}
	
	 

}
