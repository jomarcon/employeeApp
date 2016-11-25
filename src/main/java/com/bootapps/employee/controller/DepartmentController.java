package com.bootapps.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.service.DepartmentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	protected DepartmentService departmentService;	
	
    @RequestMapping(method=RequestMethod.GET)
    @ApiOperation(value="Get Departments")
    public Iterable<Department> getDepartments() {    	
        return departmentService.getDepartments(); // uses the findAll() method inherited from CrudRepository
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ApiOperation(value="Get Department by ID")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartment(id);
    }

    @RequestMapping(value="/addDepartment/{name}/{minSalary}/{maxSalary}", method=RequestMethod.POST)
    @ApiOperation(value="Add Department by Path")
    public Department addDepartment(@PathVariable("name") String name, @PathVariable("minSalary") Long minSalary,
    		@PathVariable("maxSalary") Long maxSalary)  {
    	
    	Department department = new Department();
    	department.setName(name);
    	department.setMinSalary(minSalary);
    	department.setMaxSalary(maxSalary);    	
    	
    	Department newDept = departmentService.addDepartment(department);
    	
        return newDept;
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    @ApiOperation(value="Add Department by RequestBody")
    public Department addDepartment(@RequestBody @Validated Department department)  {   	
    	Department newDept = departmentService.addDepartment(department);
    	
        return newDept;
    }
}
