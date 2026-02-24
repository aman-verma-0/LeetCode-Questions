# Write your MySQL query statement below
SELECT E.NAME AS EMPLOYEE FROM Employee e
WHERE Salary > (SELECT Salary FROM Employee WHERE Id = e.ManagerId);