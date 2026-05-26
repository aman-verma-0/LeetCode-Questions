# Write your MySQL query statement below
select c.name AS Customers from Customers c
where c.id not in (select customerID from orders);