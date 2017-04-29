package com.equifax.serviceImpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equifax.dao.DepartmentDao;
import com.equifax.entity.Department;
import com.equifax.entity.Employee;
import com.equifax.service.DepartmentService;


@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {

	@Mock
    private DepartmentDao departmentDao;
     
    @InjectMocks
    @Autowired
    private DepartmentService departmentService;




    @Before
    public void setUp() {
    	 MockitoAnnotations.initMocks(this);
    }
	 

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDepartment() throws Exception {
		List l = new ArrayList<Employee>();
		 when(departmentDao.getDepartmentByUniqueId("5500")).thenReturn(new Department(123, "sasds","qweqweqwe", l));
	     Department d = departmentService.getDepartment("5500");
		 Assert.assertNotNull(d);
		
	}

	
	@Test
	public void testGetAllDepartment() {
		List l=new ArrayList<Department>();
	when(departmentDao.getAllDepartments()).thenReturn(l);
	List<Department> dd=departmentService.getAllDepartment();
	Assert.assertNull(dd);
	
	}

}
