
delimiter $
drop procedure if exists pb_pos_restaurant.p_cash_count;
create procedure pb_pos_restaurant.p_cash_count(
  a_cash_out double
 ,a_addtl_cash double
 ,a_cashier_session_id int
)
begin 

  update "+MyDB.getNames()+".cash_drawer cd
    set cd.cash_out = a_cash_out
       ,cd.addtl_cash = a_addtl_cash
       ,cd.date_added = current_timestamp
  where cd.cashier_session_id = a_cashier_session_id;

end; $

delimiter ;

/*
call pb_pos_restaurant.p_cash_count(
  1 -- a_cash_out double
 ,1 -- a_addtl_cash double
 ,1 -- a_cashier_session_id int
);
*/
