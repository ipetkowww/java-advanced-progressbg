-- Напишете SQL заявка за намиране на цялата информация за всички departments.
SELECT * FROM departments;

-- Напишете SQL заявка която да изкарва като резултат имената на служителите и тяхната заплата.
SELECT first_name, last_name, salary FROM employees;

-- Напишете SQL заявка за показване на всички различни заплати изплащани на служителите.
SELECT DISTINCT salary FROM employees;

-- Напишете SQL заявка която показва цялата информация за служители на позиция “AC_MGR” (Accounting Manager).
SELECT * FROM employees 
WHERE job_id = "AC_MGR";

-- Напишете SQL заявка която показва всички служители на които първото им име започва с “Sa”
SELECT first_name FROM employees WHERE first_name LIKE "sa%";

-- Напишете SQL заявка за визуализация на всички служители с заплата между 3000 и 5000
SELECT * FROM employees WHERE salary BETWEEN 3000 AND 5000;

-- Напишете SQL заявка която визуализира всички служители с заплата 2500, 4000 или 5000.
SELECT * FROM employees WHERE salary in (2500, 4000, 5000);

-- Напишете SQL заявка която визуализира всички location-и за които няма post code или state_province.
SELECT * FROM locations WHERE postal_code IS NULL OR state_province IS NULL;

-- Напишете SQL заявка която извежда всички служители с заплата повече от 10000. Подредете ги в намаляващ ред по заплата.
SELECT first_name, last_name, salary FROM employees
WHERE salary > 10000
ORDER BY salary DESC;

-- Напишете SQL заявка която извежда 5-те най-добре платени служители.
SELECT first_name, last_name, salary FROM employees
ORDER BY salary DESC
LIMIT 5;

-- Напишете SQL заявка която извежда всички departments и техните location-и. Използвайте join
SELECT d.department_name, l.city
FROM departments AS d JOIN locations AS l ON d.location_id = l.location_id;

-- Напишете SQL заявка която извежда всички locations и техните departments. В резултата трябва да се съдържа и всички локации за които няма все още отдели. (използвайте left outer join).
SELECT d.department_name, l.city
FROM locations AS l LEFT JOIN departments AS d ON l.location_id = d.location_id;

-- Напишете SQL заявка която извежда manager-a на всеки отдел.
-- select d.department_name, e.first_name, e.last_name from employees AS e
-- JOIN departments AS d ON e.department_id = e.employee_id;

-- Напишете SQL заявка която извежда всички служители от отдел ‘FINANCE’ или ‘SALES’, които са назначени между 1997 и 2000
SELECT * FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE (d.department_name = "Finance" OR d.department_name = "Sales") AND (hire_date BETWEEN "1997-01-01" AND "2000-12-31");

-- Напишете SQL заявка която извежда имената на служителя, който взима най-малка заплата. Използвайте вложенa select заявка.
SELECT * FROM employees
WHERE salary = (SELECT MIN(salary) FROM employees); 

-- Напишете SQL заявка която извежда средната заплата в отдел ‘SALES’.
SELECT ROUND(AVG(salary), 2) FROM employees
WHERE department_id = 80;

-- Напишете SQL заявка която извежда броя служители в отдел ‘SALES’.
SELECT COUNT(*) AS "people in sales" FROM employees
WHERE department_id = 80;

-- Напишете SQL заявка която извежда броя на служителите за всеки отдел и мениджър.
SELECT COUNT(e.first_name) AS "people count", d.department_name, CONCAT(e.first_name, " ", e.last_name) as "manager name" FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
GROUP BY department_name

