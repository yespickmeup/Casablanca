
delimiter $
drop function if exists pb_pos_restaurant.f_get_latest_or;
create function pb_pos_restaurant.f_get_latest_or () returns varchar(20)
r1: begin

  declare retval varchar(20);
  
  set retval = (select r.or_number from "+MyDB.getNames()+".receipts r order by r.id desc limit 1);
  
  return retval;
end r1; $
delimiter ;

-- select  pb_pos_restaurant.f_get_latest_or();
