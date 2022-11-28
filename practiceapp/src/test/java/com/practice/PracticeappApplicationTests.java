package com.practice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@AutoConfigureMockMvc
class PracticeappApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	
	RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl = "http://localhost:8080/employee/getemployeesalary/";
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getEmployeeById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/getemployee/{empId}",2))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.empId").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.empId").value(2));
	}
	
	
	

}
