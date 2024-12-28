SELECT product_name FROM netology.ORDERS
JOIN netology.CUSTOMERS c on c.id = netology.ORDERS.customer_id
WHERE LOWER(name) = LOWER(:name);