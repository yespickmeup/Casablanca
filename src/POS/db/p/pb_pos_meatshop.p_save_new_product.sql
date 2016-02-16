delimiter $

drop procedure if exists pb_pos_restaurant.p_save_new_product;
create procedure pb_pos_restaurant.p_save_new_product (
  a_lookup_code varchar(100)
 ,a_prod_name varchar(100)
 ,a_desc  varchar(100)
 ,a_price double
 ,a_qty_per_head double
 ,a_qty double
 ,a_remarks varchar(100)
) begin
  
  insert into "+MyDB.getNames()+".products(
    lookup_code
   ,product_name
   ,description
   ,price
   ,qty_per_head
   ,product_qty
   ,remarks
  ) values(
    a_lookup_code 
   ,a_prod_name 
   ,a_desc  
   ,a_price
   ,a_qty_per_head 
   ,a_qty 
   ,a_remarks 
 );

end; $

delimiter ;

/*
call pb_pos_restaurant.p_save_new_product(
  'a' -- a_lookup_code varchar(100)
 ,'a' -- a_prod_name varchar(100)
 ,'a' -- a_desc  varchar(100)
 ,1 -- a_price double
 ,1 -- a_qty_per_head double
 ,1 -- a_qty double
 ,'a' -- a_remarks varchar(100)
);
*/