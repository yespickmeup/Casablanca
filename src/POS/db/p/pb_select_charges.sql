delimiter $
drop procedure if exists pb_pos_restaurant.pb_select_charges;
create procedure pb_pos_restaurant.pb_select_charges(
     a_name varchar(100)
    ,a_date varchar(100)
)

begin
   select
   c.id
  ,c.member_name 
  ,ifnull(sum(mc.qty * mc.price),0) as credit 
  from "+MyDB.getNames()+".customers c 
   left join "+MyDB.getNames()+".member_charges mc 
   on c.id=mc.customer_id where  c.member_name 
   like concat(a_name,'%')  and mc.is_payed = 'no' group by c.id;

end; $

delimiter ;

