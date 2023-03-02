package com.webapp.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.webapp.model.Employee;

public class DepartmentData {

	private static final long SerialVersionUID = 10L;
	private long depId;
	@NotEmpty(message = "Department name is required")
	private String depName;
	private List<Employee> employee;

	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}

	@Override
	public String toString() {
		return "DepartmentData [depId=" + depId + ", depName=" + depName + ", employee=" + employee + "]";
	}

}
