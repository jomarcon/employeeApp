package com.bootapps.employee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@TableGenerator(name="dept_generator",
				table="table_ids",
				pkColumnName="table_name",
				pkColumnValue="department",
				valueColumnName="table_id")
public class Department {

	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE,  generator="dept_generator")
	protected Long id;

	@NotNull(message="error.name.notnull")
	protected String name;

	@Column(name="salary_min_range")
	@NotNull(message="error.minSalary.notnull")
	@Digits(integer=7, fraction=0, message="error.minSalary.digits")
	protected Long minSalary;

	@Column(name="salary_max_range")
	@NotNull(message="error.maxSalary.notnull")
	@Digits(integer=7, fraction=0, message="error.maxSalary.digits")
	protected Long maxSalary;

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

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

}
