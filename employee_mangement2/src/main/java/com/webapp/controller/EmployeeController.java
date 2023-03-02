package com.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.webapp.dto.EmployeeData;
import com.webapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/employees" , produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//	@GetMapping("/findAll")
//	public List<EmployeeData> findAll(){
//		return employeeService.findAll();
//	}

	
	@GetMapping("/findAll")
	public List<EmployeeData> findAll(@SortDefault(sort = "priRole") @PageableDefault(size = 20) final Pageable pageable)
{
		return employeeService..ok(employeeService.findAll(pageable));;
	}
//	Pageable paging = PageRequest.of(
//            0, 2, Sort.by("employees").ascending());
//        Page<EmployeeData> page = employeeService.findAll(paging);
// 
	
	@GetMapping("/employee/{id}")
	public EmployeeData findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/add")
	public EmployeeData create(@Valid @RequestBody EmployeeData employeeData) {
		return employeeService.create(employeeData);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return employeeService.delete(id);
	}

	@PutMapping("/update/{id}")
	public boolean update(@PathVariable Long id, @RequestBody EmployeeData employeeData) {
		return employeeService.update(id, employeeData);
	}
	
}
