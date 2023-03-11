package com.webapp.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private String emailAdd;
	private String phoneNo;
	private String address;
	private String password;

	// Default Constructor
	public Users() {
		super();
	}

	// Parematrized Constructor
	public Users(String firstName, String lastName, String emailAdd, String phoneNo, String address, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
		this.phoneNo = phoneNo;
		this.address = address;
		this.password = password;
	}

	public Users(Long userId, String firstName, String lastName, String emailAdd, String phoneNo, String address,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdd = emailAdd;
		this.phoneNo = phoneNo;
		this.address = address;
		this.password = password;
	}

	// Getter and Setter methods
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Overriding toString() method of String class
	// The toString() method returns the String representation of the object.
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAdd="
				+ emailAdd + ", phoneNo=" + phoneNo + ", address=" + address + ", password=" + password + "]";
	}

	// The hashCode() method is used to generate the hash values of objects.
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	// if(a.equals(b)){
	// checking the equality of objects using equals() methods
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(userId, other.userId);
	}

}
