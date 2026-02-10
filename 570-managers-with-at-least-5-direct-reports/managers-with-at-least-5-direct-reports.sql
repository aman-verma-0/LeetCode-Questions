# Write your MySQL query statement below
-- SELECT NAME FROM EMPLOYEE
-- GROUP BY MANAGERID 
-- HAVING COUNT(*)>4;
SELECT e2.Name
FROM Employee e1
JOIN Employee e2
ON e1.ManagerId = e2.Id
GROUP BY e1.ManagerId
HAVING COUNT(*) > 4;
