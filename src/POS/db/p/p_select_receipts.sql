delimiter $
drop procedure if exists pb_pos_restaurant.get_receipts;
create procedure pb_pos_restaurant.get_receipts(
   a_name varchar(100)
   ,a_date date
)
begin

  select
    r.or_number
   ,r.receipt_date
   ,r.tendered 
   ,discount
   from 
   "+MyDB.getNames()+".receipts r
   join "+MyDB.getNames()+".cashier_sessions cs
   on r.cashier_session_id=cs.id
   where cs.cashier_name=a_name and date(r.receipt_date)=date(a_date);

end; $

delimiter ;

/*
call pb_pos_restaurant.get_receipts('cashier','2012-04-16');

*/