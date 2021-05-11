package com.employee.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public void createEmployee(@Valid @RequestBody Employee emp) throws MethodArgumentNotValidException{
		
		LOGGER.debug("Adding a new employee entry with information: {}", emp);
		employeeService.createEmployee(emp);
		LOGGER.debug("Adding a new employee entry with information: {}", emp); 
	}
	
}
