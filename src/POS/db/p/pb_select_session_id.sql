delimiter $

drop procedure if exists pb_pos_restaurant.select_sesion_id;
create procedure pb_pos_restaurant.select_sesion_id(
     a_name varchar(100)
    ,a_date datetime
)
begin
    
    select cs.id 
    from "+MyDB.getNames()+".cashier_sessions cs
    where cs.cashier_name = a_name
      and date(cs.created) between date(a_date) and adddate(date(a_date), 0)
      and cs.login_status = 1;


end; $
delimiter ;


/*
call pb_pos_restaurant.select_sesion_id(
    'cashier' -- a_name varchar(100)
    ,'2012-03-25 00:00:00' -- a_date date
);
*/