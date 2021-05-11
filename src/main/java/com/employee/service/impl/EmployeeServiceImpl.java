package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.exception.ResourceAlreadyExitsException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.utility.ErrorConstant;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public int createEmployee(Employee employee) {

		int emailAlreadyExist = employeeRepository.chkEmailAlreadyExist(employee.getEmail());
		if(emailAlreadyExist>0) {
			throw new ResourceAlreadyExitsException(ErrorConstant.emailIdExists);
		}
		return employeeRepository.insertEmployee(employee); 
	}

}
