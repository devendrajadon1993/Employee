package com.employee.repository;

import com.employee.entity.Employee;

public interface EmployeeRepository {

	int insertEmployee(Employee employee);

	int chkEmailAlreadyExist(String email);

	int findEmployeeById(int empId);

	int deleteEmployeeById(int empId);
}
