
delimiter $
drop procedure if exists pb_pos_restaurant.p_pending_order_details_retrieve;
create procedure pb_pos_restaurant.p_pending_order_details_retrieve(
  a_pending_order_id varchar(100)
) begin

  select
    pod.id
   ,pod.pending_order_id
   ,pod.qty
   ,pod.product_name
   ,pod.price
   ,pod.amount
  from "+MyDB.getNames()+".pending_order_details pod
  where pod.customer_name = a_pending_order_id; 

end; $

delimiter ;

/*
call pb_pos_restaurant.p_pending_order_details_retrieve(
   1 -- a_pending_order_id
);  
*/
  
