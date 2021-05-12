package com.employee.repository;

import java.util.List;

import com.employee.entity.Employee;
import com.employee.view.model.ViewEmployee;

public interface EmployeeRepository {

	int insertEmployee(Employee employee);

  int chkEmailAlreadyExist(String email);

	int findEmployeeById(int empId);

	int deleteEmployeeById(int empId);

	Long getTotalEmployeeCounts(String searchTerm);

	List<ViewEmployee> getEmployeeList(String searchTerm, int pageNo, int pageSize);

}
