package com.example.employeeDetails.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeDetails.Entity.EmployeeEntity;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

	@SuppressWarnings("unchecked")
	EmployeeEntity save(EmployeeEntity employeeEntity);
}
