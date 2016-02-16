
delimiter $
drop procedure if exists pb_pos_restaurant.p_ret_cashier_session;
create procedure pb_pos_restaurant.p_ret_cashier_session(
  a_name varchar(100)
 ,a_date varchar(100)  
)
begin 
 
 select cs.id 
 from "+MyDB.getNames()+".cashier_sessions cs
 where cs.cashier_name = a_name
  and date(created) = a_date;

end; $
delimiter ;

/*

call pb_pos_restaurant.ret_cashier_session(
   :a_name 
   ,:a_date 
);
*/