package com.webapp.dao;

import com.webapp.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository  extends JpaRepository<Department, Long> {

	public Department findByDepName(String depName);

}
