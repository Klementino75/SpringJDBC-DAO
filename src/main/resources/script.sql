SELECT product_name FROM ORDERS
JOIN CUSTOMERS c on c.id = ORDERS.customer_id
WHERE LOWER(name) = LOWER(:name);