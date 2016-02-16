
delimiter $
drop procedure if exists pb_pos_restaurant.p_receipt_items_add;
create procedure pb_pos_restaurant.p_receipt_items_add(
  a_receipt_id int
 ,a_product_name varchar(100)
 ,a_unit_price double
 ,a_qty double
 ,a_category varchar(100)
 ,a_type varchar(100)
 ,a_desc varchar(200)
) begin

  insert into "+MyDB.getNames()+".receipt_items( 
    receipt_id, product_name, unit_price, qty ,cat_name,type_name,description) 
  values ( a_receipt_id, a_product_name, a_unit_price, a_qty ,a_category,a_type,a_desc);

end; $

delimiter ;

/*
call pb_pos_restaurant.p_receipt_items_add(
  1 -- a_receipt_id int
 ,'a' -- a_product_name varchar(100)
 ,1 -- a_unit_price double
 ,1 -- a_qty double
);
*/
  
