delimiter $
drop procedure if exists pb_pos_restaurant.p_pending_orders_retrieve;
create procedure pb_pos_restaurant.p_pending_orders_retrieve(
   a_customer_name varchar(100)
)
begin

  select
    po.id
   ,po.customer_name
   ,po.added
  from "+MyDB.getNames()+".pending_orders po
  where po.customer_name = a_customer_name;

end; $

delimiter ;

/*
call pb_pos_restaurant.p_pending_orders_retrieve(
   'a' -- a_customer_name
);  
*/
  
