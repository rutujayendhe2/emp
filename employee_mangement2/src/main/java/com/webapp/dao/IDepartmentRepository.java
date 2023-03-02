package com.webapp.dao;

import java.util.List;

import com.webapp.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository  extends JpaRepository<Department, Long> {

	List<Department> findByDepName(String name);

}
