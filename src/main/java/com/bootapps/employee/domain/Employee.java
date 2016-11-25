package com.bootapps.employee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@TableGenerator(name="emp_generator",
		table="table_ids",
		pkColumnName="table_name",
		pkColumnValue="employee",
		valueColumnName="table_id")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,  generator="emp_generator")
	protected Long id;
	
	@NotNull(message="error.name.notnull")
	protected String name;	
	
	@OneToOne
	@JoinColumn(name="manager_id")
	protected Employee manager;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	@NotNull(message="error.department.notnull")
	protected Department department;
	
	@NotNull(message="error.salary.notnull")
	@Digits(integer=7, fraction=0, message="error.minSalary.digits")
	protected Long salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
}
