select employee_name, department_name 
from employee a inner join department b 
on a.department=b.department_id;

select department_name, employee_name
from employee e right join department d
on e.department=d.department_id;

select employee_name, city
from location l right join employee e
on e.location=l.location_id;

SELECT * FROM employee where department=1
UNION
select * from employee where location=1;

SELECT * FROM employee where department=1
except 
select * from employee where location=1;

SELECT * FROM employee where department=1
intersect  
select * from employee where location=1;