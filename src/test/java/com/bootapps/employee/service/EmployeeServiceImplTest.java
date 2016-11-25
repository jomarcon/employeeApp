package com.bootapps.employee.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.domain.Employee;
import com.bootapps.employee.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	@Test
	public final void testGetEmployee() {
		Employee newEmployee = createTestEmployee();
		
		when(employeeRepository.findById(1L)).thenReturn(newEmployee);
		
		assertEquals(newEmployee, employeeService.getEmployee(1L));
	}

	@Test
	public final void testUpdateEmployee() {
		
		Employee newEmployee = createTestEmployee();
		
		when(employeeRepository.updateEmployee(newEmployee.getId(), newEmployee.getName(), 
				newEmployee.getManager(), newEmployee.getDepartment())).thenReturn(1);
		
		assertEquals(1, employeeService.updateEmployee(newEmployee));
	}

	@Test
	public final void testUpdateSalary() {
		
		Employee newEmployee = createTestEmployee();		
		Long salary = 65000L;		
		newEmployee.setSalary(salary);
		
		when(employeeRepository.updateSalary(newEmployee.getId(), newEmployee.getSalary())).thenReturn(1);
		
		assertEquals(1, employeeService.updateSalary(newEmployee));		
	}

	@Test
	public final void testSaveEmployee() {
		Employee newEmployee = createTestEmployee();	
		
		when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);
		
		assertEquals(newEmployee, employeeService.saveEmployee(newEmployee));		
	}

	@Test
	public final void testDeleteEmployee() {
		Employee newEmployee = createTestEmployee();	

		doNothing().when(employeeRepository).delete(newEmployee);
		
		employeeService.deleteEmployee(newEmployee);
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
