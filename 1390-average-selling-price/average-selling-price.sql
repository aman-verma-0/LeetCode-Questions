# Write your MySQL query statement below
SELECT P.PRODUCT_ID,
IFNULL(ROUND(SUM(P.PRICE*S.UNITS)/SUM(S.UNITS),2),0) AS AVERAGE_PRICE
FROM Prices p
LEFT JOIN UnitsSold S
    ON p.product_id = S.product_id
   AND S.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;