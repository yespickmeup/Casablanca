delimiter $

drop procedure if exists pb_pos_restaurant.insert_users;
create procedure pb_pos_restaurant.insert_users(
   a_user_name varchar(100)
  ,a_password varchar(100)
  ,a_user_level int
)
begin

insert into
"+MyDB.getNames()+".users(
   user_name
  ,password
  ,user_level
  )
values(
  a_user_name
 ,a_password
 ,a_user_level
);

end; $

delimiter ;

/*
call  pb_pos_restaurant.insert_users(
   :a_user_name
  ,:a_password
  ,:a_user_level
   );
*/