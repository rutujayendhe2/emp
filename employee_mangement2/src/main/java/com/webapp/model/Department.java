package com.webapp.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long depId;
	private String depName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employee;

	public Department() {
		super();
	}

	public Department(String depName, List<Employee> employee) {
		super();
		this.depName = depName;
		this.employee = employee;
	}

	public Department(Long depId, String depName, List<Employee> employee) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.employee = employee;
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(long l) {
		this.depId = l;
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

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", employee=" + employee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(depId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(depId, other.depId);
	}

}
