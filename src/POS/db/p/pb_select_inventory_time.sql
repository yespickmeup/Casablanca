
delimiter $
drop procedure if exists pb_pos_restaurant.check_time_inventory;
create procedure pb_pos_restaurant.check_time_inventory(
    a_date_added date
)
begin
  select 
  time(p.date_added)
 from 
 "+MyDB.getNames()+".inventory p
 where
 date(p.date_added)= date(a_date_added)
 group by time(p.date_added)
;

end; $

delimiter ;

/*
call pb_pos_restaurant.check_time_inventory('2012-04-01');

*/