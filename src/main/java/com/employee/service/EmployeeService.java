package com.employee.service;

import com.employee.entity.Employee;

public interface EmployeeService {

	int createEmployee(Employee employee);

	int deleteEmployeeById(int empId);
}
