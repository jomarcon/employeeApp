create table department
(	id int primary key,
	name varchar(30),
	salary_min_range int,
	salary_max_range int
);


create table employee 
( id int primary key,
  name varchar(30),
  manager_id int,
  dept_id int,
  salary int,
  constraint dept_id_fk foreign key (dept_id) references department(id)
);

create table table_ids
(
	table_id int,
  table_name varchar(30)
);