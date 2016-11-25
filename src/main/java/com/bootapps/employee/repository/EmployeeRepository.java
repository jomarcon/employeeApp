package com.bootapps.employee.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootapps.employee.domain.Department;
import com.bootapps.employee.domain.Employee;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, Long>{	
	Employee findById (@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Employee e SET e.name = :name,"
			+ "e.manager = :manager, "
			+ "e.department = :department "
			+ " WHERE e.id = :id")
	int updateEmployee(@Param("id") Long id, @Param("name") String name, 
			@Param("manager") Employee manager, @Param("department") Department department); 
	
	@Modifying
	@Query("UPDATE Employee e SET e.salary = :salary"
			+ " WHERE e.id = :id")
	int updateSalary(@Param("id") Long id, @Param("salary") Long salary);
	
}
