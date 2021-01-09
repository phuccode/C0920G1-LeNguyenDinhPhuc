select *
from products 
where quantity_in_stock >= 70 ;

select * from 
orders right join customers 
on orders.customer_id = customers.customer_id;
select * from orders;
select * from customers
where last_name = 'Roseburgh' or first_name = 'Ines';