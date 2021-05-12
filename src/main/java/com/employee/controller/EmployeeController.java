package com.employee.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.utility.CommonConstants;
import com.employee.view.model.ListModal;
import com.employee.view.model.ViewEmployee;

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
	
	@GetMapping("/employee/{empId}")
	public void deleteEmployee( @PathVariable(name="empId",required=true) int empId) {
		
		LOGGER.debug("Deleting a role entry with information: {}", empId);
		int status = employeeService.deleteEmployeeById(empId);
		LOGGER.debug("Deleting a role entry with information {}",status);
	}
	
	@GetMapping("/employee")
	public  @ResponseBody ListModal<ViewEmployee> employeeList(@RequestParam(name = "searchTerm",required = false,defaultValue = CommonConstants.EMPTY_STRING) String searchTerm,
			 @RequestParam(name = "pageNo",required = false,defaultValue = CommonConstants.ZERO) int pageNo,
			 @RequestParam(name = "pageSize",required = false,defaultValue = CommonConstants.TEN) int pageSize){
		
		 LOGGER.debug("Start Geting roles list with information");
		 ListModal<ViewEmployee> roleList = employeeService.getEmployeeList(searchTerm,pageNo,pageSize);
		 LOGGER.debug("End Geting roles list with information {} " , roleList);
		 return roleList;
	
	}
	
	
}
