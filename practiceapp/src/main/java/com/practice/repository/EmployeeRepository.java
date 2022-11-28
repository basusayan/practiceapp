package com.practice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	@Transactional
	@Modifying
	
	@Query(value = "update Employee e set e.empName=?1 where e.empId=?2")
	public int updateEmployeeName(String empName,int empId);
	
	@Query(value ="select e.empBasePay from Employee e where e.empId=?1")
	public Double getEmployeeSalaryById(int empId);

}
