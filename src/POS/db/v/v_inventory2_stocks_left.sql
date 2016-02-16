

drop view if exists pb_pos_restaurant.v_inventory2_stocks_left;
create view pb_pos_restaurant.v_inventory2_stocks_left 
as
select
  isl.id
 ,isl.lookup_code
 ,isl.prod_num
 ,i.product_name
 ,i.description
 ,i.price 
 ,isl.product_qty
 ,i.types 
 ,i.types_num 

from "+MyDB.getNames()+".inventory2_stocks_left isl
  join "+MyDB.getNames()+".inventory2 i
  on i.prod_num = isl.prod_num ;


drop view if exists "+MyDB.getNames()+".v_inventory2_stocks_left;
create view "+MyDB.getNames()+".v_inventory2_stocks_left 
 as select * from pb_pos_restaurant.v_inventory2_stocks_left;

