# Write your MySQL query statement below
select d.name as department,
e.name as employee,
e.salary as salary from employee as e
join Department as d
on e.departmentId=d.id
JOIN (
    SELECT departmentId, MAX(salary) AS maxSalary
    FROM Employee
    GROUP BY departmentId
) temp
ON e.departmentId = temp.departmentId
AND e.salary = temp.maxSalary;