# Write your MySQL query statement below
select id 
from(
    select id,recordDate,temperature,
    LAG(temperature) over (order by recordDate) as prev_temp,
    LAG(recordDate) over (order by recordDate) as preV_date
    from weather
) as w
where temperature> prev_temp and DateDiff(recordDate,prev_date)=1;
