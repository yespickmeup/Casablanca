

delimiter $

drop procedure if exists pb_pos_restaurant.select_user_details2;
create procedure pb_pos_restaurant.select_user_details2(
    a_user_name varchar(100)
)
begin

select 
  p.user_code
 ,p.user_name
 ,p.password
 ,p.user_level
from
"+MyDB.getNames()+".users p where user_name=a_user_name;

end; $
delimiter ;

-- call pb_pos_restaurant.select_user_details();
