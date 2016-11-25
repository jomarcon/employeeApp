package com.bootapps.employee.service;

import com.bootapps.employee.domain.Department;

public interface DepartmentService {
	Department getDepartment(Long id);
	
	Iterable<Department> getDepartments();
	
	Department addDepartment(Department department);
}
