package com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.webapp.dao.IEmployeeRepository;
import com.webapp.dto.EmployeeData;
import com.webapp.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class EmployeeService implements IEmployee {
	
	PasswordEncoder passwordEncoder;
	
	//DTO=>Entity
	private Employee getEmployeeEntity(EmployeeData employeeData) {
		Employee employee = new Employee();
		employee.setEmpId(employeeData.getEmpId());
		employee.setFirstName(employeeData.getFirstName());
		employee.setLastName(employeeData.getLastName());
		employee.setEmailAdd(employeeData.getEmailAdd());
		employee.setAddress(employeeData.getAddress());
		employee.setPhoneNo(employeeData.getPhoneNo());
		employee.setStatus(employeeData.getStatus());

		return employee;
	}
	
	//Entity=>DTO
	private EmployeeData getEmployeeData(Employee employee) {
		EmployeeData employeeData = new EmployeeData();
		employeeData.setEmpId(employee.getEmpId());
		employeeData.setFirstName(employee.getFirstName());
		employeeData.setLastName(employee.getLastName());
		employeeData.setEmailAdd(employee.getEmailAdd());
		employeeData.setAddress(employee.getAddress());
		employeeData.setPhoneNo(employee.getPhoneNo());
		employeeData.setStatus(employee.getStatus());

		return employeeData;
		
	}
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<EmployeeData> findAll() {
		List<EmployeeData> employeeDataList = new ArrayList<>();
		List<Employee> employees = employeeRepository.findAll();
		employees.forEach(employee -> {
			employeeDataList.add(getEmployeeData(employee));
		});
		return employeeDataList;
	}

	@Override
	public EmployeeData findById(Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if (employeeOptional == null) {
			new EntityNotFoundException("Employee Not Found");
		}
		return getEmployeeData(employeeOptional.get());

	}
	
	@Override
	public EmployeeData create(EmployeeData employeeData) {
		Employee employee = getEmployeeEntity(employeeData);
		return getEmployeeData(employeeRepository.save(employee));
	}

	@Override
	public boolean delete(Long id) {
		boolean test = findAll().remove(findById(id));
		employeeRepository.deleteById(id);
		return test;
	}

	@Override
	public boolean update(Long id, EmployeeData employeeData) {
		Employee employee = employeeRepository.findById(id).get();
		if (employee != null) {
			employee.setFirstName(employeeData.getFirstName());
			employee.setLastName(employeeData.getLastName());
			employee.setEmailAdd(employeeData.getEmailAdd());
			employee.setPhoneNo(employeeData.getPhoneNo());
			employee.setAddress(employeeData.getAddress());
			employee.setStatus(employeeData.getStatus());
			employeeRepository.save(employee);
			
			return true;
		}
		return false;
	}

	
}

