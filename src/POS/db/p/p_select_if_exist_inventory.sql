delimiter $

drop procedure if exists pb_pos_restaurant.check_inventory_if_exists;
create procedure pb_pos_restaurant.check_inventory_if_exists(
    a_name varchar(100)
    ,a_date_added date
    ,a_time varchar(100)
)
begin
    select
    physical_count
    ,variance
    ,beg
    ,end
    ,total

    from 
    "+MyDB.getNames()+".inventory
    where date(date_added) between date(a_date_added) and date(a_date_added)
    and name=a_name
    and time(date_added)=a_time
    
    ;
end; $

delimiter ;

/*

call pb_pos_restaurant.check_inventory_if_exists('CHORIZO','2012-04-01','11:24:39');

*/
