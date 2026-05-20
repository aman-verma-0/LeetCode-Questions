
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
READS SQL DATA
BEGIN
  SET N= N-1;
  RETURN (
      select distinct salary as getNthHighestSalary from Employee
      order by salary Desc
      Limit N,1
    );
END 