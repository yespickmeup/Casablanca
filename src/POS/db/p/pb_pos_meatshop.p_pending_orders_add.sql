delimiter $
drop procedure if exists pb_pos_restaurant.p_pending_orders_add;
create procedure pb_pos_restaurant.p_pending_orders_add(
   a_customer_name varchar(100)
)
begin

  insert into "+MyDB.getNames()+".pending_orders(
    customer_name
  ) values (
    a_customer_name
  );

  set @c_pending_order_id = last_insert_id();

  select po.id from "+MyDB.getNames()+".pending_orders po where po.id = @c_pending_order_id;

end; $

delimiter ;

/*
call pb_pos_restaurant.p_pending_orders_add(
   'a' -- a_customer_name
);  
*/
  
