use sql_store;
select * from customers;
select * from orders;

select * from customers 
right join orders 
on customers.customer_id = orders.customer_id
where city = 'Orlando';

select * from customers
left join orders
on customers.customer_id = orders.customer_id
where phone is null;

 select status from orders