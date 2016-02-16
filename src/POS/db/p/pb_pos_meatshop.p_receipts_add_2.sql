delimiter $
drop procedure if exists pb_pos_restaurant.p_receipts_add2;
create procedure pb_pos_restaurant.p_receipts_add2 (
  a_cashier_session_id int
 ,a_tendered double
 ,a_or_number varchar(20)
 ,a_receipt_date datetime
 ,a_discount double
 ,a_credit double
 ,a_approval_code varchar(200)
 ,a_member_id varchar(200)
 ,a_is_payed varchar(100)
)
begin

  insert into "+MyDB.getNames()+".receipts( 
    cashier_session_id
   ,tendered
   ,or_number
   ,receipt_date
   ,discount
   ,credit
   ,approval_code
   ,member_id
   ,is_payed


 )
  values( 
    a_cashier_session_id
   ,a_tendered
   ,a_or_number
   ,a_receipt_date 
   ,a_discount
   ,a_credit
   ,a_approval_code
   ,a_member_id
   ,a_is_payed   
);

  set @c_receipt_id = last_insert_id();

  select po.or_number from "+MyDB.getNames()+".receipts po where po.or_number = @c_receipt_id;

end; $

delimiter ;

/*
call pb_pos_restaurant.p_receipts_add( 
  1 -- a_cashier_session_id int
 ,1 -- a_tendered double
 ,'a' -- a_or_number varchar(20)
 ,current_timestamp -- a_receipt_date datetime
);
*/
