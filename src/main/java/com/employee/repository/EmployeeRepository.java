package com.employee.repository;

import com.employee.entity.Employee;

public interface EmployeeRepository {

	int insertEmployee(Employee employee);

	int chkEmailAlreadyExist(String email);
}
