package com.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.webapp.dto.DepartmentData;
import com.webapp.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path="/departments" , produces = "application/json")
@CrossOrigin(origins = "*")
public class DepatmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/findAll")
	public List<DepartmentData> findAll(){
		return departmentService.findAll();
	}
	
	@GetMapping("/department/{id}")
	public DepartmentData findById(@PathVariable Long id) {
		return departmentService.findById(id);
	}
	
	@PostMapping("/add")
	public DepartmentData creata(@Valid @RequestBody DepartmentData departmentData) {
		return departmentService.create(departmentData);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return departmentService.delete(id);
	}

	@PutMapping("/update/{id}")
	public boolean update(@PathVariable Long id, @RequestBody DepartmentData departmentData) {
		return departmentService.update(id, departmentData);
	}
}
