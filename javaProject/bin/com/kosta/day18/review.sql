(1) s_emp 테이블에서 사원의 이름,직책,커미션을 출력하시오.
     이때 커미션이 없는 사원은 3%의 커미션을 적용한다. 
select first_name, department_id,
        salary*nvl(commission_pct, 0.03) commission
from employees;

(2) s_emp 테이블에서 사원의 이름,직책,커미션을 출력하시오.
     이때 커미션이 있는 사원은 5% , 커미션이 없는 사원은 3%의 커미션을 적용한다. 
select first_name, department_id,
        salary*nvl2(commission_pct, 0.05, 0.03) commission
from employees;

(3) s_emp 테이블에서 mailid가 a로 시작하는 직원의 이름,메일을 검색하시오.
select first_name
from employees
where first_name like 'A%';

(4) s_emp 테이블에서 커미션이 있으면 커미션을 커미션이 없으면 해당 급여를 , 모두 없으면 100을 출력하시오.
select coalesce(commission_pct, salary, 100)
from employees;

(5) 부서번호가 20이면  마켓팅, 30이면 구매팀, 40이면 hr팀 그렇지않으면 부서없음을 출려하시오 
select decode(department_id, 20, '마켓팅',
                    30, '구매팀',
                    40, 'hr팀',
                    '부서없음')
 from employees;

(6) S_EMP 테이블에서 직책이 부장이면 급여의 10%, 과장이면 7%, 
   사원이면 5%의 급여를 인상하려고 한다. 
    DECODE와 CASE문을 이용하여 급여가 많은 사람부터 출력하시오.
select first_name, department_id, salary,
        decode(department_id, 50, salary*1.05,
                    60, salary*1.07,
                    20, salary*1.1) 급여
from employees
order by 급여 desc nulls last;

