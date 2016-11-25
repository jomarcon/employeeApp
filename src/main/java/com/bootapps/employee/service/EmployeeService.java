package com.bootapps.employee.service;

import com.bootapps.employee.domain.Employee;

public interface EmployeeService {
	Employee getEmployee( Long id );
	
	int updateEmployee(Employee employee);
	
	int updateSalary(Employee employee);
	
	Employee saveEmployee(Employee employee);
	
	void deleteEmployee(Employee employee);
}
