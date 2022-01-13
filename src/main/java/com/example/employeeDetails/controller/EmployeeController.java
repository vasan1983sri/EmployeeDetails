package com.example.employeeDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeDetails.Entity.EmployeeEntity;
import com.example.employeeDetails.request.EmployeeRequest;
import com.example.employeeDetails.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping(path="/v1", consumes="Application/json", produces="Application/json")
	public ResponseEntity<EmployeeEntity> getEmployeeDetails(@RequestBody EmployeeRequest empRequest)
	{
		//EmployeeService empService = new EmployeeService();
		EmployeeEntity emp = empService.processEmployeeDetails(empRequest);		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
}
