package com.bootapps.employee.service;

import static org.junit.Assert.assertEquals;
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

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {

	@Mock
	private DepartmentRepository departmentRepository;

	@InjectMocks
	private DepartmentServiceImpl departmentService;

	@Test
	public void testGetDepartment() {
		Department newDepartment = createTestDepartment();
		
		when(departmentRepository.findById(1L)).thenReturn(newDepartment);

		assertEquals(newDepartment, departmentService.getDepartment(1L));
	}

	@Test
	public void testGetDepartments() {
		List<Department> departments = new ArrayList<Department>();
		departments.add(createTestDepartment());

		when(departmentRepository.findAll()).thenReturn(departments);

		assertEquals(1, ((List<Department>) departmentService.getDepartments()).size());
	}

	@Test
	public void testAddDepartment() {
		Department newDepartment = createTestDepartment();

		when(departmentRepository.save(newDepartment)).thenReturn(newDepartment);

		assertEquals(newDepartment, departmentService.addDepartment(newDepartment));
	}

	private Department createTestDepartment() {
		Department newDepartment = new Department();
		newDepartment.setId(1L);
		newDepartment.setName("HR");
		newDepartment.setMinSalary(50000L);
		newDepartment.setMaxSalary(70000L);

		return newDepartment;
	}

}
