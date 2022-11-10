-- Q1
select * from city
order by city desc
limit 10;

-- Q2
select * from film
where title like '%airplane%';

-- Q3
select max(amount) from payment;

-- Q4
select count(*) from customer
where store_id = 1;

-- Q5
select * from payment
inner join customer
using (`customer_id`)
where email = 'NANCY.THOMAS@sakilacustomer.org';

-- Q6
select * from film_list
where actors like '%bob fawcett%';

-- Q7
call film_in_stock
((select film_id from film
  where title like '%alien center%'),
  2 , -- storeID = 2
 @count
);

-- Q8
start transaction;

insert into staff (first_name, last_name, address_id,
                   picture, email, store_id,
                   active, username, password, last_update)
values ('Elliot', 'Alderson', 75,
         null, 'ealder@gmail.com', 2,
         1, 'alder', null, current_time());

insert into store (manager_staff_id, address_id, last_update)
values ((select staff_id from staff -- no ID hard coding
         where first_name = 'Elliot' and last_name = 'Alderson'),
         34, current_time());

commit;

-- Q9
-- Done automatically by current_time() in Q8
update store
set last_update = current_timestamp()
where manager_staff_id = (select staff_id from staff
                          where first_name = 'Elliot' and
                          last_name = 'Alderson');

-- Q10
delete from store
where manager_staff_id = (select staff_id from staff
                          where first_name = 'Elliot' and
                                last_name = 'Alderson');

-- Q11
select category_id, count(*)
from film_category
group by category_id;

-- Q12
select first_name, last_name, total from customer
inner join (select customer_id, sum(amount) as total
            from payment group by customer_id
            order by total desc limit 3) as top3
using (`customer_id`);

-- Q13
select * from film
inner join
      (select film_id from inventory
       inner join
             (select * from rental
              where customer_id = (select customer_id from payment
                                   group by customer_id
                                   order by sum(amount) desc limit 1)) as rented
       using (`inventory_id`)) as films
using (`film_id`);

-- Q14
select first_name, last_name, total from customer
inner join (select customer_id, sum(amount) as total
            from payment group by customer_id) as foo
using (`customer_id`)
where total > 150;
