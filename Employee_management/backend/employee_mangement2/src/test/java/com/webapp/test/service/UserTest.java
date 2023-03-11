package com.webapp.test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webapp.dto.EmployeeData;
import com.webapp.dto.UserData;
import com.webapp.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userService;
	private UserData userData;
	

	@BeforeEach()
	public void beforeEach() {
		userData=new UserData();
		
		userData.setFirstName("Rutuja");
		userData.setLastName("Yendhe");
		userData.setEmailAdd("rutu@gmail.com");
		userData.setPhoneNo("8940284024");
		userData.setAddress("Pune");
		userData.setPassword("12345678");
		
	}
	
	
	@Test
	public void testFindAllNotNull() {
		assertNotNull(userService.findAll());
		
	}
	
	@Test
	public void testCreateNew() {	
		assertNotNull(userService.create(userData));
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		Long id=1l;
		assertNotNull(userService.findById(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id=1l;
		assertTrue(userService.delete(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		Long id=1l;
		assertTrue(userService.update(id, userData));
	}

}

