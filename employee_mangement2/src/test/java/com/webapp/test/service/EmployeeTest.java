package com.webapp.test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webapp.dto.EmployeeData;
import com.webapp.service.EmployeeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class EmployeeTest {

	@Autowired
	private EmployeeService employeeService;
	private EmployeeData employeeData;
	
	@BeforeEach()
	public void beforeEach() {
		employeeData=new EmployeeData();
		
		employeeData.setFirstName("Rutuja");
		employeeData.setLastName("Yendhe");
		employeeData.setEmailAdd("rutu@gmail.com");
		employeeData.setPhoneNo("8940284024");
		employeeData.setAddress("Pune");
		employeeData.setStatus("Active");
		
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		assertNotNull(employeeService.findAll());
	}
	
	@Test
	public void testCreateNew() {	
		assertNotNull(employeeService.create(employeeData));
	}
	

	@Test
	public void testFindOneNotNull() {
		Long id=1l;
		assertNotNull(employeeService.findById(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id=1l;
		assertTrue(employeeService.delete(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		Long id=1l;
		assertTrue(employeeService.update(id, employeeData));
	}

}

