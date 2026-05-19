# Write your MySQL query statement below
With sec_highest_sal_view AS(
    select salary,
    dense_rank() over (order by salary desc) as rnk
    from employee
)
select (
    select salary from sec_highest_sal_view 
    where rnk=2
    limit 1
)AS secondHighestSalary;