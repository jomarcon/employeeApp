package com.bootapps.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.employee.domain.Employee;
import com.bootapps.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ApiOperation(value="Get Employee")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(value="/updateEmployee", method=RequestMethod.PUT)
	@ApiOperation(value="Update Employee")
	public int updateEmployee(@RequestBody Employee employee) {	
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/updateSalary", method=RequestMethod.PUT)
	@ApiOperation(value="Update Employee salary")
	public int updateSalary(@RequestBody Employee employee) {
		return employeeService.updateSalary(employee);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiOperation(value="Create new Employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ApiOperation(value="Delete Employee")
	public void deleteEmployee(@PathVariable("id") Long id) {		
		employeeService.deleteEmployee(employeeService.getEmployee(id));
	}
	
}
