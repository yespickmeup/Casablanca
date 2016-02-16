delimiter $
drop procedure if exists pb_pos_restaurant.p_update_product;
create procedure pb_pos_restaurant.p_update_product(
  a_product_name varchar(100)
 ,a_price double
 ,a_est_heads double
 ,a_no_of_heads double
)
begin 
  update "+MyDB.getNames()+".products p
    set p.price = a_price
       ,p.qty_per_head = a_est_heads
       ,p.product_qty = a_no_of_heads
       ,p.product_qty2 = a_no_of_heads
  where
    product_name like a_product_name;


  /*

  insert into "+MyDB.getNames()+".inventory(
    
  ) values (

  );
*/

end; $

delimiter ;

/*
call pb_pos_restaurant.p_update_product(
  'KASIM' -- a_product_name varchar(100)
 ,1 -- a_price double
 ,1 -- a_est_heads double
 ,1 -- a_no_of_heads double
);
*/
