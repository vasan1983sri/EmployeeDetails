package com.example.employeeDetails.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeDetails.Entity.EmployeeEntity;
import com.example.employeeDetails.repository.EmployeeRepository;
import com.example.employeeDetails.request.EmployeeRequest;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeEntity processEmployeeDetails(EmployeeRequest empRequest)
	{
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity.setEmpName(empRequest.getEmpName());
		empEntity.setCreatedDate(getTodayCurrentDate());
		
		EmployeeEntity emp = employeeRepository.save(empEntity);
		return emp;
		
	}
	
	public static Timestamp getTodayCurrentDate()
	{
		String now = LocalDateTime.now(ZoneOffset.UTC)
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss.SSS"));
		return Timestamp.valueOf(now);
	}
	

}
