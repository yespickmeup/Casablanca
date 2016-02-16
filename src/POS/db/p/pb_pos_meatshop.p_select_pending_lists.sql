
delimiter $
drop procedure if exists pb_pos_restaurant.p_select_pending_lists;
create procedure pb_pos_restaurant.p_select_pending_lists(
  a_customer_name varchar(100)
)
begin

  select
    p.qty
   ,p.product_name
   ,p.price
   ,p.amount
   ,p.description
  from "+MyDB.getNames()+".pending_order_details p
  where customer_name = a_customer_name;

end; $

delimiter ;

/*
call pb_pos_restaurant.select_pending_lists(
  'a' -- :a_customer_name
);
*/


