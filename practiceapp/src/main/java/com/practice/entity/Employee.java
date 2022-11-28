package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name ="uuid", strategy="org.hibernate.id.UUIDGenerator")
	@Column
	private int empId;
	@Column
	@NotNull(message="Name cannot be null")
	private String empName;
	@Column
	private String empDesignation;
	@Column
	private double empBasePay;
	@Column
	private String doj;
	@Email
	@Column
	private String empEmail;
	@Transient
	private int age;
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public double getEmpBasePay() {
		return empBasePay;
	}

	public void setEmpBasePay(double empBasePay) {
		this.empBasePay = empBasePay;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
