package com.bootapps.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootapps.employee.domain.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

//	Iterable<Department> findAll();

	Department findById(@Param("id") Long id);

//	Iterable<Department> findByName(@Param("name") String name);

//	Department save(Department department);
}
