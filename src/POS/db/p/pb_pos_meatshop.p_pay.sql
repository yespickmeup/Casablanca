

delimiter $
drop procedure if exists pb_pos_restaurant.p_pay;
create procedure pb_pos_restaurant.p_pay (
  a_tendered double
 ,a_receipt_date datetime
 ,a_cashier_name varchar(100)
 ,a_or_number varchar(20)
 
 ,a_product_name varchar(100)
 ,a_unit_price double
 ,a_qty double
)
begin

  -- look for the cashier_name that is login
  -- login
  set @v_cashier_cid = (select cs.id
                       from "+MyDB.getNames()+".cashier_sessions cs
                       where 
                          cs.login_status = 1
                        and cs.cashier_name like a_cashier_name);
                              
  if( @v_cashier_cid is null ) then
     insert into "+MyDB.getNames()+".cashier_sessions( 
       cashier_name
      ,login_status
      ,modified )
     values( 
       a_cashier_name
      ,1
      ,current_timestamp
     );
     
     set @v_cashier_cid = last_insert_id();    
  end if; 
  
  -- insert sa receipt
  set @v_receipt_cid = (select r.id
                        from "+MyDB.getNames()+".receipts r
                        where 
                          r.cashier_session_id = @v_cashier_cid
                          and r.or_number like a_or_number );
  
  if( @v_receipt_cid is null ) then
     insert into "+MyDB.getNames()+".receipts (
       cashier_session_id
      ,tendered
      ,or_number
      ,receipt_date
     ) values (
       @v_cashier_cid
      ,a_tendered
      ,a_or_number
      ,a_receipt_date
     );
     
     set @v_receipt_cid = last_insert_id();
  end if;
  
  -- insert receipt items
  insert into "+MyDB.getNames()+".receipt_items (
    receipt_id
   ,product_name
   ,unit_price
   ,qty
  ) values (
    @v_receipt_cid
   ,a_product_name
   ,a_unit_price
   ,a_qty
  );
  
  
end; $

delimiter ;

/*
call pb_pos_restaurant.pay (
  100 -- a_tendered double
 ,current_timestamp -- a_receipt_date datetime
 ,'cashier2' -- a_cashier_name varchar(100)
 ,'1235' -- a_or_number varchar(20)
 
 ,'product1' -- a_product_name varchar(100)
 ,10 -- a_unit_price double
 ,2 -- a_qty double
);
*/