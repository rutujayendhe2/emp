package com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import com.webapp.dao.IDepartmentRepository;
import com.webapp.dto.DepartmentData;
import com.webapp.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {

	//DTO=>Entity
		private Department getDepartmentEntity(DepartmentData departmentData) {
			Department department = new Department();
			department.setDepId(departmentData.getDepId());
			department.setDepName(departmentData.getDepName());
			department.setEmployee(departmentData.getEmployee());
			return department;
		}
		
		//Entity=>DTO
			private DepartmentData getDepartmentData(Department department) {
				DepartmentData departmentData = new DepartmentData();
				departmentData.setDepId(department.getDepId());
				departmentData.setDepName(department.getDepName());
				departmentData.setEmployee(department.getEmployee());
				return departmentData;
			}
			
			@Autowired
			private IDepartmentRepository departmentRepository;
			
			
	@Override
	public List<DepartmentData> findAll() {
		List<DepartmentData> departmentDataList = new ArrayList<>();
		List<Department> departments = departmentRepository.findAll();
		departments.forEach(department -> {
			departmentDataList.add(getDepartmentData(department));
		});
		return departmentDataList;
	}

	@Override
	public DepartmentData findById(Long id) {
		Optional<Department> departmentOptional = departmentRepository.findById(id);
		if (departmentOptional == null) {
			new EntityNotFoundException("department Not Found");
		}
		 return getDepartmentData(departmentOptional.get());
	}

	@Override
	public DepartmentData create(DepartmentData departmentData) {
		Department department = getDepartmentEntity(departmentData);
		return getDepartmentData(departmentRepository.save(department));
	}

	@Override
	public boolean delete(Long id) {
		boolean test = findAll().remove(findById(id));
		departmentRepository.deleteById(id);
		 return test;
	}

	@Override
	public boolean update(Long id, DepartmentData t) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public List<Department> findByDepName(String name) {
//		List<DepartmentData> departmentDataList = new ArrayList<>();
//		List<Department> departments = departmentRepository.findByDepName(name);
//		for(Department dept : departments) {
//			departmentDataList.add(getDepartmentData(dept));
//		}
//		if (departments == null) {
//			new EntityNotFoundException("department Not Found");
//		}
//		 return (departments);
//	}
	
	public DepartmentData findByDepName(String depName) {
		Department dept = departmentRepository.findByDepName(depName);
		System.out.println(dept);
		if (dept != null) {
			return getDepartmentData(dept);
			
		}
		 return null;

	}
	
}
