/*
| cashier_sessions          |
| cash_in                   |
| accounts                  | w
| cash_drawer               |


| dates                     | w
| head_endorsements         |
| inventory                 |
| inventory_dates           |
| key_products              |
| pending_order_details     |
| pending_orders            |
| products                  |
| receipt_items             |
| receipts                  |
| system_date               |
| users                     |
*/

drop schema if exists db_pos_restaurant;
create schema db_pos_restaurant;

drop table if exists "+MyDB.getNames()+".cashier_sessions;
create table "+MyDB.getNames()+".cashier_sessions (
  id int primary key auto_increment
 ,cashier_name varchar(100)
 ,login_status int  -- 0 logout, 1 login, 2 standby
 ,cash_count double default 0
 ,additional_cash double default 0
 ,created datetime
 ,modified datetime 
 ,login_time datetime
 ,logout_time datetime
);

drop table if exists "+MyDB.getNames()+".cash_in;
create table "+MyDB.getNames()+".cash_in(
  id int auto_increment primary key
 ,cashier_name varchar(100)
 ,cashier_session_id int
 ,date_added timestamp default current_timestamp
);

drop table if exists "+MyDB.getNames()+".accounts;
create table "+MyDB.getNames()+".accounts (
  id int auto_increment primary key
 ,account_name varchar(100) 
 ,date_added timestamp default current_timestamp
 ,exp_date datetime
);

drop table if exists "+MyDB.getNames()+".dates;
create table "+MyDB.getNames()+".dates (
  id int auto_increment primary key
 ,sys_date timestamp default current_timestamp
);

drop table if exists "+MyDB.getNames()+".receipts;
create table "+MyDB.getNames()+".receipts (
  id int primary key auto_increment
 ,cashier_session_id int
 ,tendered double
 ,or_number int
 ,receipt_status int default 0 -- 0 ok, 1 canceled
 ,receipt_date datetime
 ,discount double
 ,credit double
 ,approval_code varchar(200)
 ,member_id varchar(100)
 ,is_payed varchar(100)
);



drop table if exists "+MyDB.getNames()+".receipt_discount;
create table "+MyDB.getNames()+".receipt_discount(
    id int auto_increment primary key
    ,or_number varchar(100)
    ,disc_no int
    ,disc_name varchar(100)
    ,disc_percent double
    ,disc_rate double
    ,cust_name varchar(100)
    ,cust_no varchar(100)
    ,cust_address varchar(100)
);

drop table if exists "+MyDB.getNames()+".discounts;
create table "+MyDB.getNames()+".discounts(
    id int auto_increment primary key
    ,name varchar(200)
    ,rate double
);



drop table if exists "+MyDB.getNames()+".receipt_items;
create table "+MyDB.getNames()+".receipt_items (
  id int primary key auto_increment
 ,receipt_id int
 ,product_name varchar(100)
 ,unit_price double
 ,qty double
 ,type_name varchar(200)
 ,cat_name varchar(100)
 ,description varchar(100)
);

drop table if exists "+MyDB.getNames()+".key_products;
create table "+MyDB.getNames()+".key_products(
  id int auto_increment primary key
  ,key_number int
  ,key_size  int
  ,date_added timestamp default current_timestamp
);



drop table if exists "+MyDB.getNames()+".products;
create table "+MyDB.getNames()+".products (
  id int primary key auto_increment
 ,lookup_code varchar(20)
 ,prod_num int
 ,unique(lookup_code)
 ,product_name varchar(100)
 ,unique(product_name)
 ,description varchar(100)
 ,price double
 ,qty_per_head double
 ,product_qty double
 ,product_qty2 double
 ,remarks varchar(200)
 ,created timestamp default current_timestamp
 ,modified datetime
 ,types varchar(100)
 ,types_num varchar(100)
);  


/*
         category1..sample// drinks,meat,bread,toiletries
*/

drop table if exists "+MyDB.getNames()+".category;
create table "+MyDB.getNames()+".category(
    id int auto_increment primary key
    ,cat_num int
    ,cat_name varchar(200)
);


drop table if exists "+MyDB.getNames()+".category_type;
create table "+MyDB.getNames()+".category_type(
    id int auto_increment primary key
    ,type_num int
    ,type_name varchar(200)
    ,cat_num varchar(100)
    ,cat_name varchar(100)
);



/*
drop table if exists "+MyDB.getNames()+".products;
create table "+MyDB.getNames()+".products(
  id int primary key auto_increment
 ,trans_no int
 ,key_category int 
 ,lookup_code varchar(20)
 ,unique(lookup_code)
 ,product_name varchar(100)
 ,unique(product_name)
 ,description varchar(100)
 ,price double
 ,qty_per_head double
 ,product_qty double
 ,product_qty2 double
 ,remarks varchar(200)
 ,created timestamp default current_timestamp
 ,modified datetime
 ,updated_by varchar(100)
);  
 */

drop table if exists "+MyDB.getNames()+".users;
create table "+MyDB.getNames()+".users (
  id int primary key auto_increment
 ,user_code varchar(20)
 ,user_name varchar(100)
 ,password varchar(200)
 ,user_level int
 ,remarks varchar(100)
 ,created timestamp default current_timestamp
 ,modified datetime 
);



-- 
-- drop table if exists "+MyDB.getNames()+".head_endorsements;
-- create table "+MyDB.getNames()+".head_endorsements (
--   id int primary key auto_increment
--  ,date_delivered datetime 
--  ,no_of_heads_endorsed double
--  ,product_id int
--  ,no_of_products_per_head double
--  ,total_kilos double
--  ,remarks varchar(100)
--  ,remarks2 varchar(100)
-- );

drop table if exists "+MyDB.getNames()+".endorsements;
create table "+MyDB.getNames()+".endorsements(
    id int auto_increment primary key
    ,product_id varchar(100)
    ,product_name varchar(100)
    ,qty_endorsed double
    ,qty_left double
    ,date_added datetime
    ,cashier_id int
    ,remarks varchar(100)
);

drop table if exists "+MyDB.getNames()+".endorsement_histories;
create table "+MyDB.getNames()+".endorsement_histories(
     id int auto_increment primary key
    ,product_id varchar(100)
    ,product_name varchar(100)
    ,prev_endorsed double
    ,qty_endorsed double
    ,date_added datetime
    ,cashier_id int
    ,remarks varchar(100)
);

drop table if exists "+MyDB.getNames()+".cancelled_endorsements;
create table "+MyDB.getNames()+".cancelled_endorsements(
     id int auto_increment primary key
    ,product_id varchar(100)
    ,product_name varchar(100)
    ,prev_endorsed double
    ,qty double
    ,date_added datetime
    ,cashier_id int
    ,remarks varchar(100)
);



drop table if exists "+MyDB.getNames()+".sales;
create table "+MyDB.getNames()+".sales(
     id int auto_increment primary key
    ,product_id varchar(100)
    ,product_name varchar(100)
    ,price double
    ,qty_sold double
    ,date_added datetime
    ,cashierid int
    ,cat_id int
    ,commission double
    ,remitance double
    ,remit_cost double
);

drop table if exists "+MyDB.getNames()+".cancelled_sales;
create table cancelled_sales(
     id int auto_increment primary key
    ,product_id varchar(100)
    ,product_name varchar(100)
    ,price double
    ,qty double
    ,date_added datetime
);

drop table if exists "+MyDB.getNames()+".cash_drawer;
create table "+MyDB.getNames()+".cash_drawer(
  id int auto_increment primary key
 ,cashier_session_id int
 ,user_name varchar(100)
 ,date_added datetime
 ,cash_in double
 ,cash_out double
 ,addtl_cash double
);


drop table if exists "+MyDB.getNames()+".pending_orders;
create table "+MyDB.getNames()+".pending_orders(
  id int auto_increment primary key
 ,customer_name varchar(100)
 ,unique(customer_name)
 ,added timestamp default current_timestamp
);

drop table if exists "+MyDB.getNames()+".pending_order_details;
create table "+MyDB.getNames()+".pending_order_details(
  id int auto_increment primary key
 ,pending_order_id int
 ,customer_name varchar(100)
 ,qty double
 ,product_name varchar(100)
 ,price double
 ,amount double
);

drop table if exists "+MyDB.getNames()+".system_date;
create table "+MyDB.getNames()+".system_date(
  id int auto_increment primary key
 ,curr_date datetime
);

drop table if exists "+MyDB.getNames()+".inventory;
create table "+MyDB.getNames()+".inventory(
	id int auto_increment primary key
	,name varchar(100)
	,beg double
	,end double
	,total double
	,physical_count double
	,variance double
	,date_added datetime
);

drop table if exists "+MyDB.getNames()+".inventory_dates;
create table "+MyDB.getNames()+".inventory_dates(
  id int auto_increment primary key
 ,date_added datetime
);

drop table if exists "+MyDB.getNames()+".cancelled_or;
create table "+MyDB.getNames()+".cancelled_or(
   id int auto_increment primary key
);


drop table if exists "+MyDB.getNames()+".inventory2;
create table "+MyDB.getNames()+".inventory2(
  id int primary key auto_increment
 ,lookup_code varchar(20)
 ,prod_num int
 ,product_name varchar(100)
 ,description varchar(100)
 ,price double
 ,qty_per_head double
 ,product_qty double
 ,remarks varchar(200)
 ,created timestamp default current_timestamp
 ,modified datetime
 ,types varchar(100)
 ,types_num varchar(100)
 ,updated_by varchar(100)
 ,supplier_id int
 ,is_vat tinyint
 ,cost double
);

drop table if exists "+MyDB.getNames()+".inventory2_stocks_left;
create table "+MyDB.getNames()+".inventory2_stocks_left(
  id int primary key auto_increment
 ,lookup_code varchar(20)
 ,prod_num int
 ,product_name varchar(100)
 ,description varchar(100)
 ,price double
 ,product_qty double
 ,types varchar(100)
 ,types_num varchar(100)
 ,is_vat varchar(100)
 ,prod_assembly tinyint
 ,is_linient tinyint
 ,w_commission tinyint
 ,comm_amount double
 ,cat_id int
 ,cost double
);




drop table if exists "+MyDB.getNames()+".stock_out;
create table "+MyDB.getNames()+".stock_out(
    id int auto_increment primary key
    ,prod_num varchar(200)
    ,prod_name varchar(200)
    ,qty double
    ,amount double 
    ,date_added datetime
    ,cashier_name varchar(100)
    ,cashier_id varchar(100)
    ,remarks varchar(200)
    ,branch_id int
    ,branch varchar(200)
    ,status int
);

drop table if exists "+MyDB.getNames()+".stock_out_main;
create table "+MyDB.getNames()+".stock_out_main(
    id int auto_increment primary key
    ,ref_no varchar(100)
    ,item_count int
    ,total_cost double
    ,date_added datetime
    ,branch varchar(100)
    ,branch_id int
    ,user_name varchar(100)
    ,user_id int
    ,status int
);
drop table if exists "+MyDB.getNames()+".stock_in;
create table "+MyDB.getNames()+".stock_in(
    id int auto_increment primary key
    ,prod_num varchar(200)
    ,prod_name varchar(200)
    ,qty double
    ,amount double 
    ,date_added datetime
    ,cashier_name varchar(100)
    ,cashier_id varchar(100)
    ,remarks varchar(200)
    ,branch_id int
    ,branch varchar(200)
    ,status int
);

drop table if exists "+MyDB.getNames()+".stock_in_main;
create table "+MyDB.getNames()+".stock_in_main(
    id int auto_increment primary key
    ,ref_no varchar(100)
    ,item_count int
    ,total_cost double
    ,date_added datetime
    ,branch varchar(100)
    ,branch_id int
    ,user_name varchar(100)
    ,user_id int
    ,status int
);

drop table if exists "+MyDB.getNames()+".product_supplier;
create table "+MyDB.getNames()+".product_supplier(
    id int auto_increment primary key
    ,supplier_name varchar(200)
    ,address varchar(100)
    ,contact varchar(100)
    ,rep varchar(100)
);


drop table if exists "+MyDB.getNames()+".cancelled_order;
create table "+MyDB.getNames()+".cancelled_order(
   id int auto_increment primary key
   ,or_num int
   ,or_date datetime
   ,prod_name varchar(100)
   ,qty int
   ,price double
);

drop table if exists "+MyDB.getNames()+".bank;
create table "+MyDB.getNames()+".bank(
    id int auto_increment primary key
    ,bank_name varchar(200)
);

drop table if exists "+MyDB.getNames()+".bank_card_type;
create table "+MyDB.getNames()+".bank_card_type(
    id int auto_increment primary key
    ,bank_id int
    ,name varchar(200)
);
drop table if exists "+MyDB.getNames()+".credits;
create table "+MyDB.getNames()+".credits(
    id int auto_increment primary key
    ,or_no varchar(100)
    ,bank_name varchar(200)
    ,card_type varchar(100)
    ,card_holder varchar(200)
    ,card_no varchar(200)
    ,approval_code varchar(200)
    ,amount double
);


drop table if exists "+MyDB.getNames()+".customers;
create table "+MyDB.getNames()+".customers(
    id int auto_increment primary key
    ,member_name varchar(200)
    ,address  varchar(200)
    ,contact  varchar(200)
    ,occupation varchar(200)
    ,income varchar(200)
    ,b_date date
    ,civil_status varchar(200)
    ,is_male  tinyint
    ,balance double
    ,credit_limit double
    ,group int
);

drop table if exists "+MyDB.getNames()+".customer_charges;
create table "+MyDB.getNames()+".customer_charges(
    id int auto_increment primary key
    ,cust_num varchar(100)
    ,cust_name varchar(100)
    ,or_num varchar(100)
    ,ci_num varchar(100)
    ,amount double
    ,date_added datetime
    ,is_payed varchar(100)
    ,date_payed datetime
    ,user_name varchar(200)
    ,user_id varchar(100)
);

drop table if exists "+MyDB.getNames()+".patronages;
create table "+MyDB.getNames()+".patronages(
    id int auto_increment primary key
    ,cashier_id int
    ,customer_id int
    ,amount double
    ,update datetime
    ,created datetime
);

drop table if exists "+MyDB.getNames()+".shortcuts;
create table "+MyDB.getNames()+".shortcuts(
    id int auto_increment primary key
    ,cashier_id int
    ,prod_id int
);


drop table if exists "+MyDB.getNames()+".tables;
create table "+MyDB.getNames()+".tables(
    id int auto_increment primary key
    ,table_name varchar(100)
    ,rate double
);


drop table if exists "+MyDB.getNames()+".customer_tables;
create table "+MyDB.getNames()+".customer_tables(
    id int auto_increment primary key
    ,table_no varchar(100)
    ,date_added datetime
    ,amount double
    ,or_no varchar(100)
    ,status int
    ,guest_id varchar(100)
    ,fname varchar(100)
    ,mi varchar(100)
    ,lname varchar(100)
    ,email_address varchar(100)
);

drop table if exists "+MyDB.getNames()+".customer_tables_details;
create table "+MyDB.getNames()+".customer_tables_details(
  id int auto_increment primary key
 ,table_no_id varchar(100)
 ,or_no varchar(100)
 ,qty double
 ,product_name varchar(100)
 ,description varchar(100)
 ,price double
 ,img_path varchar(500)
 ,status int
);

insert into "+MyDB.getNames()+".customer_tables(table_no,date_added,amount,or_no)values('5','2012-06-01',200.00,'2131');
      
drop table if exists "+MyDB.getNames()+".ci_no;
create table "+MyDB.getNames()+".ci_no(
    id int auto_increment primary key
    ,ci_num int
);



drop table if exists "+MyDB.getNames()+".favorites;
create table "+MyDB.getNames()+".favorites(
    id int auto_increment primary key
    ,prod_code varchar(100)
);

drop table if exists "+MyDB.getNames()+".uom;
create table "+MyDB.getNames()+".uom(
    id int auto_increment primary key
    ,product_id varchar(100)
    ,name varchar(100)
    ,amount double
);

drop table if exists "+MyDB.getNames()+".member_charges;
create table "+MyDB.getNames()+".member_charges(
    id int auto_increment primary key
    ,cashier_id int
    ,customer_id int
    ,product_id varchar(100)
    ,product_name varchar(200)
    ,qty double
    ,price double
    ,date_added datetime
    ,is_payed varchar(100)
    ,date_payed datetime
    ,user_id int 
);

drop table if exists "+MyDB.getNames()+".product_uom;
create table "+MyDB.getNames()+".product_uom(
    id int auto_increment primary key
    ,uom varchar(100)
    ,uom_amount double
    ,prod_num varchar(100)
);
drop table if exists "+MyDB.getNames()+".uom;
create table "+MyDB.getNames()+".uom(
    id int auto_increment primary key
    ,uom varchar(100)
    ,uom_amount double
);

drop table if exists "+MyDB.getNames()+".commission;
create table "+MyDB.getNames()+".commission(
    id int auto_increment primary key
    ,cat_id int
    ,total_sales double
    ,commission double
    ,date datetime
);

drop table if exists "+MyDB.getNames()+".direct_credit;
create table  "+MyDB.getNames()+".direct_credit(
    id int auto_increment primary key
    ,cashier_id int
    ,date_added date
    ,amount double
);

drop table if exists "+MyDB.getNames()+".sales_commission;
create table  "+MyDB.getNames()+".sales_commission(
    id int auto_increment primary key
    ,cashier_id int
    ,comm double
    ,date_added date
);

drop table if exists "+MyDB.getNames()+".guests;
create table "+MyDB.getNames()+".guests(
    id int auto_increment primary key
    ,guest_id varchar(100)
    ,fname varchar(100)
    ,lname varchar(100)
    ,mi varchar(100)
    ,country varchar(100)
    ,email_address varchar(100)
    ,status int 
);

insert into "+MyDB.getNames()+".ci_no(ci_num)values(1000);

-- drop database if exists pb_pos_restaurant;
create database pb_pos_restaurant;


