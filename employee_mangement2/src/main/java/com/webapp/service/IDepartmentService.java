package com.webapp.service;

import java.util.List;

import com.webapp.dto.DepartmentData;
import com.webapp.model.Department;

public interface IDepartmentService extends IService<DepartmentData> {

	List<Department> findByDepName(String name);
}
