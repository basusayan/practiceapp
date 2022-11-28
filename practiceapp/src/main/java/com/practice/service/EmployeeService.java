package com.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> employeeList.add(e));
		return employeeList;
	}
	
	public int addNewEmployee(Employee emp) {
		try {
		Employee empAdded = employeeRepository.save(emp);
		System.out.println(empAdded.getEmpId());
		return empAdded.getEmpId();
		}
		catch(Exception ex) {
			return 0;
		}
		
	}
	
	public Employee getEmployeeByID(int empId) {
		Optional<Employee> empExist = employeeRepository.findById(empId);
		if(empExist.isPresent()) {
			return empExist.get();
		}
		return null;
	}
	
	public int updateEmployee(int empId,Employee emp) {
		Optional<Employee> empExist = employeeRepository.findById(empId);
		if(empExist.isPresent()) {
			Employee existingEmployee = employeeRepository.findById(empId).get();
			existingEmployee.setEmpName(emp.getEmpName());
			existingEmployee.setEmpDesignation(emp.getEmpDesignation());
			existingEmployee.setDoj(emp.getDoj());
			existingEmployee.setEmpBasePay(emp.getEmpBasePay());
			existingEmployee.setEmpEmail(emp.getEmpEmail());
			employeeRepository.save(existingEmployee);
			return empId;
		}
		return 0;
	}
	
	public int deleteEmployee(int empId) {
		Optional<Employee> empExist = employeeRepository.findById(empId);
		if(empExist.isPresent()) {
		employeeRepository.deleteById(empId);
		return empId;
		}
		return 0;
	}
	
	
	public int updateEmployeeName(int empId,String empName) {
		return employeeRepository.updateEmployeeName(empName,empId);
	}
	
	public Double getEmployeeSalaryById(int empId) {
		return employeeRepository.getEmployeeSalaryById(empId);
	}
}
