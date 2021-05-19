package com.employee.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;

import com.employee.entity.Employee;
import com.employee.exception.ResourceAlreadyExitsException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.impl.EmployeeServiceImpl;

public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void add_NewEmployeeEntry_ShouldSaveEmployeeEntry() {
		Employee emp = new Employee("Dev", "Jadon", "Jadon@gmail.com", "8854963371");
		given(employeeRepository.chkEmailAlreadyExist(emp.getEmail())).willReturn(0);
		given(employeeRepository.insertEmployee(emp)).willReturn(1);
		employeeService.createEmployee(emp);
		verify(employeeRepository, times(1)).insertEmployee(emp);

	}

	@Test(expected = ResourceAlreadyExitsException.class)
	public void add_NewEmployeeEntry_EmployeeEntryAlready_Exists_ShouldThrowException() {

		Employee emp = new Employee("Dev", "Jadon", "Jadon@gmail.com", "8854963371");
		given(employeeRepository.chkEmailAlreadyExist(emp.getEmail())).willReturn(1);
		employeeService.createEmployee(emp);
		verify(employeeRepository, times(1)).insertEmployee(emp);
	}

	@Test
	public void deleteById_EmployeeEntryFound_ShouldDeleteEmployeeEntryAndReturnIt() {
		int employeeId = 3;
		given(employeeRepository.findEmployeeById(employeeId)).willReturn(1);
		given(employeeRepository.deleteEmployeeById(employeeId)).willReturn(1);
		employeeService.deleteEmployeeById(employeeId);
		verify(employeeRepository, times(1)).deleteEmployeeById(employeeId);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void deleteById_EmployeeEntryNotFound_ShouldThrowException() {
		int employeeId = 3;
		given(employeeRepository.findEmployeeById(employeeId)).willReturn(0);
		employeeService.deleteEmployeeById(employeeId);
		verify(employeeRepository, times(1)).deleteEmployeeById(employeeId);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void update_EmployeeEntryFound_ShouldUpdateEmployeeEntry() {
		int employeeId = 3;
		Employee emp = new Employee("Dev", "Jadon", "Jadon@gmail.com", "8854963371");
		given(employeeRepository.findEmployeeById(employeeId)).willReturn(0);
		employeeService.updateEmployeeById(employeeId, emp);
		verify(employeeRepository, times(1)).updateEmployeeById(employeeId, emp);
	}

	@Test
	public void update_EmployeeEntryNotFound_ShouldThrowException() {
		int employeeId = 3;
		Employee emp = new Employee("Dev", "Jadon", "Jadon@gmail.com", "8854963371");
		given(employeeRepository.findEmployeeById(employeeId)).willReturn(1);
		employeeService.updateEmployeeById(employeeId, emp);
		verify(employeeRepository, times(1)).updateEmployeeById(employeeId, emp);
	}

}
