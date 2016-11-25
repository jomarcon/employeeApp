package com.bootapps.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bootapps.employee.domain.Employee;
import com.bootapps.employee.repository.EmployeeRepository;

@Component
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee.getId(), employee.getName(), employee.getManager(), 
				employee.getDepartment());
	}

	@Override
	public int updateSalary(Employee employee) {
		return employeeRepository.updateSalary(employee.getId(), employee.getSalary());
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
	}

}
