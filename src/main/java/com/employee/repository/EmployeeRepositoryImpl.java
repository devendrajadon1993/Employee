package com.employee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public int insertEmployee(Employee employee) {

		String sql = "INSERT INTO employee (first_name,last_name, email, phone) VALUES (:firstName, :lastName,:email, :phoneNo)";
		 
	    BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
	    
	    return namedParameterJdbcTemplate.update(sql, paramSource);
	}


	@Override
	public int chkEmailAlreadyExist(String email) {

		String sql = "SELECT count(*) from employee where email= ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { email }, Integer.class);
	}


	@Override
	public int findEmployeeById(int empId) {
		String sql = "SELECT count(*) from employee where id= ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { empId }, Integer.class);
	}


	@Override
	public int deleteEmployeeById(int empId) {
		String sql = "delete from employee where id= ?";
		return jdbcTemplate.update(sql, empId);
	}
	
	
}
