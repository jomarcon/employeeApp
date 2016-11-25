package com.bootapps.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.repository.DepartmentRepository;
import com.bootapps.employee.service.DepartmentService;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {

	@Mock
	private DepartmentRepository departmentRepository;
	
	@Mock
	private DepartmentService departmentService;
	
	@InjectMocks
	private DepartmentController departmentController;
	
	@Test
	public final void testDepartments() {		
		List<Department> departments = new ArrayList<Department>();
		departments.add(createTestDepartment());
		
		when(departmentService.getDepartments()).thenReturn(departments);
		
		assertEquals(departments.size(), ((List<Department>)departmentController.getDepartments()).size());		
	}

	@Test
	public final void testDepartmentsById() {
		Department newDepartment = createTestDepartment();
		
		when(departmentService.getDepartment(1L)).thenReturn(newDepartment);
		
		assertEquals(newDepartment, departmentController.getDepartmentById(1L));		
	}

	@Test
	public final void testAddDepartmentByPath() {
		Department newDepartment = new Department();		
//		newDepartment.setId(1L);
		newDepartment.setName("Some Department");
		newDepartment.setMinSalary(50000L);
		newDepartment.setMaxSalary(70000L);	
		
		
		when(departmentRepository.save(newDepartment)).thenReturn(newDepartment);
		when(departmentService.addDepartment(newDepartment)).thenReturn(newDepartment);
		
		
//		assertEquals(newDepartment, departmentController.addDepartment(newDepartment.getName(), 
//				newDepartment.getMinSalary(), newDepartment.getMaxSalary()));		
	}

	@Test
	public final void testAddDepartmentByBody() {
		Department newDepartment = new Department();
		newDepartment.setId(1L);
		newDepartment.setName("Some Department");
		newDepartment.setMinSalary(50000L);
		newDepartment.setMaxSalary(70000L);
		
		when(departmentService.addDepartment(newDepartment)).thenReturn(newDepartment);
		
		assertEquals(newDepartment, departmentController.addDepartment(newDepartment));
	}
	
	private Department createTestDepartment() {
		Department newDepartment = new Department();
		newDepartment.setId(1L);
		newDepartment.setName("Some Department");
		newDepartment.setMinSalary(50000L);
		newDepartment.setMaxSalary(70000L);

		return newDepartment;
	}

}
