delimiter $
drop procedure if exists pb_pos_restaurant.update_inventory;
create procedure pb_pos_restaurant.update_inventory(
    a_name varchar(100)
    ,a_count double 
    ,a_variance double
    ,a_date date
    ,a_time varchar(100)
)
begin
    update "+MyDB.getNames()+".inventory set
    physical_count=a_count
    ,variance=a_variance
    where name=a_name
    and date(date_added) between date(a_date) and date(a_date)
    and time(date_added)=a_time
    ;
end; $
delimiter ;