관계형 데이터 베이스



테이블

행 = COLUMN

열 = RECORD = ROW

SQL = 관계형 데이터베이스 활용 문법 언어를 의미한다





DATa QUERY LAND ==> DQL ==> 조회

select first_name, department_id, salary from employees where job_id IN (select job_id from employees where first_name = 'William');



select employee_id, first_name, salary from employees where salary > all (select salary from employees where first_name = 'William');



select employee_id, first_name, salary from employees where salary > any (select salary from employees where first_name = 'William');





conn hr/hr
employees


1. 2002년 이후에 입사한 직원들 중에서 급여가 13000 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.

```sql
select first_name, salary, department_id, hire_date from employees where salary between 13000 and 20000 and hire_date >= '01/JAN/02';
```

```sql
SELECT first_name, salary, department_id, hire_date FROM employees WHERE  hire_date >= TO_DATE('2002', 'YYYY') AND salary BETWEEN 13000 AND 20000;
```




2. 근무한지 10년이 넘은 사원의 이름과 근무년수를 조회하시오.

```sql
SELECT first_name, TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12,0) FROM employees WHERE TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12,0) <= 365*10;
```



![스크린샷 2021-03-24 오후 10.29.41](md-images/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-03-24%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2010.29.41.png)



3. 직원 중에서 상관이 없는 직원의 이름과 급여를 조회하시오.
   상관의 정보는 manager_id 컬럼에 있습니다.

SELECT first_name, salary from employees where NOT_EXISTS (SELECT * FROM emoloyees WHERE manager_id);

SELECT first_name, salary from employees where 

```sql

```





4. 10, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id를 조회하시오.

SELECT first_name, salary, department_id FROM employees 
WHERE salary >= 13000 and department_id in (10, 50);



5. 직종이 clerk 직종인 직원의 이름, 급여, 직종코드를 조회하시오.
   (clerk 직종은 job_id에 CLERK을 포함하거나
   CLERK으로 끝난다.)



6. 12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.



7. 이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.



8. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.



9. 커미션을 받는 직원의 이름, 커미션, 총급여를 조회하시오.
   총급여는 커미션*급여로 계산합니다



10. 커미션을 받지 않는 직원의 이름, 급여를 조회하시오.
11. 10월에 입사해서 30, 50, 80 번 부서에 속해있으면서, 
급여를 5000 이상 17000 이하를 받는 직원을 조회하시오. 
단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이 
먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.

SELECT first_name, salary, hire_date, department_id FROM employees 
WHERE department_id in (30, 50, 80) and hire_date LIKE '__/10/__' and 
salary between 5000 and 17000 and commission_pct is not null 
ORDER BY hire_date, salary desc;



10. jobs 테이블
    job_id : 직종코드
    job_title : 직종명
    max_salary : 해당직종 최대급여
    min_salary : 해당직종 최소급여

select job_title, min_salary, max_salary from jobs where job_title = 'President' or job_title = 'Administration Vice President';



jobs 테이블에서 회장과 부회장의 직종명, 최소급여,최대급여를 조회하시오.
 job_title은 직종명이고 회장은 president, 부회장은 vise president를 포함합니다.


13. 
countries 테이블
country_id : 국가코드
country_name : 국가이름

countries 테이블에서 국가이름이 United Kingdom 인 국가의
국가코드를 조회하시오.

14. 
locations 테이블
city : 도시이름
country_id : 도시가 위치한 국가코드

13번에서 조회한 결과를 이용하여 United Kingdom에 위치한
도시이름을 조회하시오.