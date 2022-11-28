package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Employee;
import com.practice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getemployee")
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> allEmployee = employeeService.getAllEmployee();
		if(!allEmployee.isEmpty())
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		return new ResponseEntity<String>("There is no Employee",HttpStatus.NO_CONTENT);
			
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee){
		int empId = employeeService.addNewEmployee(employee);
		if(empId != 0)
			return new ResponseEntity<Integer>(empId,HttpStatus.CREATED);
		return new ResponseEntity<String>("Validation failed",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getemployee/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId){
		Employee emp = employeeService.getEmployeeByID(empId);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp){
		int employeeId = employeeService.updateEmployee(emp.getEmpId(), emp);
		if(employeeId !=0) {
			return new  ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Id does not exist",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deleteemployee/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int empId){
		int employeeId = employeeService.deleteEmployee(empId);
		if(employeeId !=0) {
			return new  ResponseEntity<Integer>(employeeId,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Id does not exist",HttpStatus.BAD_REQUEST);
	} 
	
	@PutMapping("/updateemployeename")
	public ResponseEntity<String> updateEmpName(@RequestBody Employee emp){
		int rowsAffected = employeeService.updateEmployeeName(emp.getEmpId(),emp.getEmpName());
		
		if(rowsAffected !=0) {
			return new ResponseEntity<String>(emp.getEmpName(),HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("ID Doesn't exist",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getemployeesalary/{empId}")
	public ResponseEntity<?> getEmployeeSalaryById(@PathVariable int empId){
		Double empSalary = employeeService.getEmployeeSalaryById(empId);
		if(empSalary !=null)
			
			return new ResponseEntity<Double>(empSalary,HttpStatus.OK);
		return new ResponseEntity<String>("ID Does not exist",HttpStatus.OK);
	}
}
