-- 1. Get 10 cities in descending alphabetical order.
select * from city
order by city desc
limit 10;

-- 2. Get all films with "airplane" in the title.
select * from film
where title like '%airplane%';

-- 3. Get the highest payment amount.
select max(amount) from payment;

-- 4. Get the number of records in the customer table for store id #1.
select count(*) from customer
where store_id = 1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"
select * from payment
inner join customer
using (`customer_id`)
where email = 'NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.
select * from film_list
where actors like '%bob fawcett%';

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2.
call film_in_stock
((select film_id from film
  where title like '%alien center%'),
  2 , -- storeID = 2
 @count
);

-- 8. Insert a new store. Ensure that you use TRANSACTION.
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

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 
-- Done automatically by current_time() in #8
update store
set last_update = current_timestamp()
where manager_staff_id = (select staff_id from staff
                          where first_name = 'Elliot' and
                          last_name = 'Alderson');

-- 10. Delete the new store.
delete from store
where manager_staff_id = (select staff_id from staff
                          where first_name = 'Elliot' and
                                last_name = 'Alderson');

-- 11. Using one SQL statement, get how many films are there in each rating category.
select category_id, count(*)
from film_category
group by category_id;

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.
select first_name, last_name, total from customer
inner join (select customer_id, sum(amount) as total
            from payment group by customer_id
            order by total desc limit 3) as top3
using (`customer_id`);

-- 13. Get all movies rented by the customer who spent the most.
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

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.
select first_name, last_name, total from customer
inner join (select customer_id, sum(amount) as total
            from payment group by customer_id) as foo
using (`customer_id`)
where total > 150;
