CREATE TABLE department (
	department_id int primary key,
	department_name varchar(50),
	monthly_budget numeric(7,2)
);

CREATE TABLE location (
	location_id	int	primary key,
	street	varchar(25)	,
	city	varchar(25)	,
	state	varchar(2)	,
	zipcode	int
);


CREATE TABLE employee (
	employee_id	int	primary key,
	employee_name varchar(64),
	birthday date,
	monthly_salary numeric(7,2) NOT null,
	department int references department(department_id) NOT null,
	hire_date date,
	position varchar(20),
	manager	int,
	location int references	location(location_id)
);

INSERT INTO department VALUES (1, 'ACCOUNTING', 2000);
INSERT INTO department VALUES (2, 'MARKETING', 3000);
INSERT INTO department VALUES (3, 'INFORMATION TECHNOLOGY', 4000);
INSERT INTO department VALUES (4, 'HUMAN RESOURCES', 5000);
INSERT INTO department VALUES (5, 'LEGAL', 5000);
INSERT INTO department VALUES (6, 'CUSTOMER SERVICE', 3000);

INSERT INTO location VALUES (1, '14 MAIN ST', 'RESTON', 'VA', 20190);
INSERT INTO location VALUES (2, '960 TCHOUPITOULAS ST', 'NEW ORLEANS', 'LA', 70118);
INSERT INTO location VALUES (3, '200 LOMBARD ST', 'SAN FRANCISCO', 'CA', 94109);

INSERT INTO employee VALUES (1, 'JOHN SMITH', DATE '1994-01-01', 2000, 1, DATE '2015-03-28', 'AC_ACCOUNT', NULL, 1);
INSERT INTO employee VALUES (2, 'JAMES BOSH', DATE '1990-06-14', 3200, 2, DATE '2016-05-28', 'MK_REP', NULL, 2);
INSERT INTO employee VALUES (3, 'LISA JACKSON', DATE '1992-09-08', 3800.00, 3, DATE '2017-02-02', 'IT_PROF', NULL, 3);
INSERT INTO employee VALUES (4, 'ANGELA DEAN', DATE '1986-05-15', 2000.00, 3, DATE '2015-03-28', 'IT_PROF',3, NULL);
INSERT INTO employee VALUES (5, 'NIGEL OAKS', DATE '1990-09-24', 2500.00, 2, DATE '2018-01-03', 'MK_REP',2, 2);
INSERT INTO employee VALUES (6, 'JAMES BOND', DATE '1994-11-13', 2800.00, 2, DATE '2017-05-05', 'MK_REP',2, 3);
INSERT INTO employee VALUES (7, 'JILLIAN KYND', DATE '1980-10-15', 2840.00, 1, DATE '2015-05-11', 'AC_ACCOUNT', 1, NULL);
INSERT INTO employee VALUES (8, 'TIM KIBBEL', DATE '1980-05-20', 2240.00, 2, DATE '2014-07-28', 'MK_REP', 2, 1);
INSERT INTO employee VALUES (9, 'ETHELIN COMINI', DATE '1982-06-16', 3380.00, 3, DATE '2017-10-02', 'IT_DEV', 3, 1);
INSERT INTO employee VALUES (10, 'JASE HANDLEY', DATE '1975-10-08', 1870.00, 5, DATE '2017-08-17', 'LG_LAW',11, NULL);
INSERT INTO employee VALUES (11, 'ARIEL PAVIS', DATE '1981-09-23', 4500.00, 5, DATE '2015-07-12', 'LG_LAW', NULL, 2);
INSERT INTO employee VALUES (12, 'MELISSA ITZKOVSKY', DATE '1983-03-03', 3870.00, 5, DATE '2014-09-15', 'LG_LAW',11, 2);
INSERT INTO employee VALUES (13, 'MALIA FILISOV', DATE '1976-07-11', 4620.00, 6, DATE '2014-11-09', 'CS_REP', NULL, 2);
INSERT INTO employee VALUES (14, 'BRENDAN LOUISET', DATE '1979-01-21', 3760.00, 6, DATE '2018-03-28', 'CS_REP',13, 2);
INSERT INTO employee VALUES (15, 'MILT KLIEMANN', DATE '1983-02-25', 3820.00, 1, DATE '2016-05-01', 'AC_ACCOUNT', 1, 2);
INSERT INTO employee VALUES (16, 'LUCILLE HUNE', DATE '1994-01-04', 2300.00, 2, DATE '2016-04-17', 'MK_REP',2, 2);
INSERT INTO employee VALUES (17, 'PETA POLTZOLD', DATE '1990-09-24', 2500.00, 3, DATE '2015-07-10', 'IT_DEV',3, 3);
INSERT INTO employee VALUES (18, 'LYDIA POVER', DATE '1991-10-01', 2800.00, 3, DATE '2016-08-03', 'IT_DEV', NULL, 3);
INSERT INTO employee VALUES (19, 'RON WINTERTON', DATE '1977-09-27', 2500.00, 5, DATE '2018-02-23', 'LG_LAW', 11, 3);
INSERT INTO employee VALUES (20, 'NITIN CHESTNUT', DATE '1995-01-18', 2800.00, 6, DATE '2014-10-25', 'CS_REP', 13, NULL);

select count(*) from employee;

select department,round(avg(monthly_salary)) from employee group by department order by department asc;

SELECT * FROM employee 
WHERE monthly_salary = ( SELECT MAX(monthly_salary) FROM employee );