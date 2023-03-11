package com.webapp.service;

import java.util.List;

public interface IService<T> {
	
	//Get list of all existing employees
	List<T> findAll();
	
	//Get details for a particular employee based on employee id
	T findById(final Long id);
	
	//Add new Employee
	T create(T t);

	//Delete existing employee
	boolean delete(final Long id);
	
	//Update existing employee
	boolean update(final Long id, T t);
	
	
}
