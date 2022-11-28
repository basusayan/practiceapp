package com.practicerestclient.controller;

import java.awt.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.practicerestclient.entity.Employee;
@RestController
public class RestClient {

	final String BASE_API_URL = "http://localhost:8080/employee";
	RestTemplate restTemplate = new RestTemplate();
	
	
	@GetMapping("/get_emp_salary/{empId}")
	public ResponseEntity<?> getEmployeeSalaryById(@PathVariable int empId){
		ResponseEntity<Double> responseDouble = restTemplate.getForEntity(BASE_API_URL+"/getemployeesalary/"+empId, Double.class);
		return responseDouble;
	}
	
	@GetMapping("/get_all_emps")
	public ResponseEntity<?> getAllEmployees(){
		Employee[] empList = restTemplate.getForObject(BASE_API_URL+"/getemployee", Employee[].class);
		return new ResponseEntity<>(Arrays.asList(empList),HttpStatus.OK);
	}
}
