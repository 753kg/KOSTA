select employee_id, first_name||last_name fullname
from EMPLOYEES
where employee_id in (select distinct manager_id from employees);

select distinct job_id from employees;

select employee_id, first_name, job_id, department_id from employees order by 4;

select * from DEPARTMENTS;

select * from jobs;