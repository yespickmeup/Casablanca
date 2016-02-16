



-- 
-- insert into "+MyDB.getNames()+".key_products(
--   key_number
--  ,key_size
-- ) values
--   (1,0);
-- 
-- insert into "+MyDB.getNames()+".key_products(
--   key_number
--  ,key_size
-- ) values 
--   (1, 0);

-- insert into "+MyDB.getNames()+".products(
--   key_category
--  ,product_name
--  ,price
--  ,product_qty
--  ,product_qty2
-- ) values
--   (1, 'TENDERLOIN(LOMO)', 200, 0, 0)
--  ,(1, 'LEANMEAT', 195, 0, 0)
--  ,(1, 'LEIMPO', 185, 0, 0)
--  ,(1, 'KASIM', 185, 0, 0)
--  ,(1, 'STRAIGHT CUT', 175, 0, 0)
--  ,(1, 'PORK CHOP', 175, 0, 0)
--  ,(1, 'TI-IL (FRONT)', 130, 0, 0)
--  ,(1, '(BACK)', 120, 0, 0)
--  ,(1, 'DIlA', 120, 0, 0)
--  ,(2, 'APING', 120, 0, 0)
--  ,(2, 'ATAY', 120, 0, 0)
--  ,(2, 'SALISI', 110, 0, 0)
--  ,(2, 'BUKOG', 80, 0, 0)
--  ,(2, 'PANIT', 70, 0, 0)
--  ,(2, 'EMPLEYA', 70, 0, 0)
--  ,(2, 'DRESSED CHICKEN', 125, 0, 0)
--  ,(2, '(BOUNTY FRESH/MAGNOLIA)', 125, 0, 0)
--  ,(2, 'EGG', 125, 0, 0)
--  ,(3, 'CHORIZO', 110, 0, 0)
--  ,(3, 'CHICHARON', 110, 0, 0)
--  ,(3, 'TENDER JUICY', 110, 0, 0)
--  ,(3, 'HOTDOG', 110, 0, 0);



-- insert into "+MyDB.getNames()+".system_date(
--   curr_date
-- ) values
--   ('2012-01-29');


insert into "+MyDB.getNames()+".users(
  user_name
  ,password
  ,user_level
)values
  ('admin','admin',1)
  ,('cashier','cashier',0);
    
insert into "+MyDB.getNames()+".category(cat_num,cat_name)
values
(1,'Dog')
,(2,'Cat')
,(3,'Rat')
,(4,'Chicken')
,(5,'Bird')
,(6,'Fish')
,(7,'Pig')
,(8,'Cow')
,(9,'Snake');

insert into "+MyDB.getNames()+".category(cat_num,cat_name)
values
(10,'Cheeta')
,(11,'Rabbit')
,(12,'Horse')
,(13,'Bat')
,(14,'Dragon')
,(15,'ANt')
,(16,'Toko')
,(17,'Bear')
,(18,'Heena');

insert into "+MyDB.getNames()+".category(cat_num,cat_name)
values
(19,'Elephant')
,(20,'Rhino')
,(21,'Owl')
,(22,'Dinausor')
,(23,'Beetle')
,(24,'Koala')
,(25,'Tarsier')
,(26,'Penguin')
,(27,'Seal');

insert into "+MyDB.getNames()+".category(cat_num,cat_name)
values
(10,'Butterfly');

insert into "+MyDB.getNames()+".product_supplier(supplier_name)
values
('LEE'),
('Synapse');