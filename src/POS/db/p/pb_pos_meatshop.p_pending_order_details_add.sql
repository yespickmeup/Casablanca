
delimiter $
drop procedure if exists pb_pos_restaurant.p_pending_order_details_add;
create procedure pb_pos_restaurant.p_pending_order_details_add(
  a_pending_order_id int
 ,a_qty double
 ,a_customer_name varchar(100)
 ,a_product_name varchar(100)
 ,a_price double
 ,a_amount double
) begin

  insert into "+MyDB.getNames()+".pending_order_details (
    pending_order_id
   ,qty
   ,customer_name
   ,product_name
   ,price
   ,amount
 ) values(
    a_pending_order_id
   ,a_qty
   ,a_customer_name
   ,a_product_name
   ,a_price
   ,a_amount
 );

end; $

delimiter ;

/*
call pb_pos_restaurant.p_pending_order_details_add(
   1 -- a_pending_order_id
  ,1 -- a_qty
  ,'a' -- a_product_name
  ,1 -- a_price
  ,1 -- a_amount
);  
*/
  
