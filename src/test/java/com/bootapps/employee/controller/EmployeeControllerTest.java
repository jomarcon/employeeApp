package com.bootapps.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.domain.Employee;
import com.bootapps.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Test
	public final void testGetEmployee() {
		Employee newEmployee = createTestEmployee();
		
		when(employeeService.getEmployee(1L)).thenReturn(newEmployee);
		
		assertEquals(newEmployee, employeeController.getEmployee(1L));		
	}

	@Test
	public final void testUpdateEmployee() {
		Employee newEmployee = createTestEmployee();
		
		when(employeeService.updateEmployee(newEmployee)).thenReturn(1);
		
		assertEquals(1, employeeController.updateEmployee(newEmployee));		
	}

	@Test
	public final void testUpdateSalary() {
		Employee newEmployee = createTestEmployee();
		
		when(employeeService.updateSalary(newEmployee)).thenReturn(1);
		
		assertEquals(1, employeeController.updateSalary(newEmployee));		
	}

	@Test
	public final void testSaveEmployee() {
		Employee newEmployee = createTestEmployee();
		
		when(employeeService.saveEmployee(newEmployee)).thenReturn(newEmployee);
		
		assertEquals(newEmployee, employeeController.saveEmployee(newEmployee));		
	}

	@Test
	public final void testDeleteEmployee() {
		Employee newEmployee = createTestEmployee();
		
		doNothing().when(employeeService).deleteEmployee(newEmployee);
	}

	private Employee createTestEmployee() {
		Employee newEmployee = new Employee();
		newEmployee.setId(2L);
		newEmployee.setName("Some Employee");
		newEmployee.setSalary(60000L);
		
		Employee manager = new Employee();
		manager.setId(1L);
		manager.setName("Some Manager");
		manager.setSalary(100000L);
		
		Department newDepartment = new Department();
		newDepartment.setId(1L);
		newDepartment.setName("Some Deparment");
		newDepartment.setMinSalary(50000L);
		newDepartment.setMaxSalary(70000L);
		
		newEmployee.setManager(manager);
		newEmployee.setDepartment(newDepartment);
		
		return newEmployee;
	}
	
}
