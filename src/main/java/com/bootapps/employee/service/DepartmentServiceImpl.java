package com.bootapps.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.repository.DepartmentRepository;

@Component
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department getDepartment(Long id) {		
		return departmentRepository.findById(id);
	}

	@Override
	public Iterable<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

}
