export master_host=root # ${db.host}
export master_port=3306 # ${db.port}
export master_user=root # ${db.username}
export master_password=password # ${db.password}

echo 'setup db_pos_meatshop.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/db_pos_meatshop.sql 
echo 'setup db_pos_meatshop.seed_data.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/seed/db_pos_meatshop.seed_data.sql 


echo 'setup pb_pos_meatshop.p_cash_count.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_cash_count.sql
echo 'setup pb_pos_meatshop.p_pay.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_pay.sql 
echo 'setup pb_pos_meatshop.p_pending_order_details_add.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_pending_order_details_add.sql
echo 'setup pb_pos_meatshop.p_pending_order_details_retrieve.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_pending_order_details_retrieve.sql
echo 'setup pb_pos_meatshop.p_pending_orders_add.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_pending_orders_add.sql
echo 'setup pb_pos_meatshop.p_pending_orders_retrieve.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_pending_orders_retrieve.sql
echo 'setup pb_pos_meatshop.p_receipt_items_add.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_receipt_items_add.sql
echo 'setup pb_pos_meatshop.p_receipts_add.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_receipts_add.sql
echo 'setup pb_pos_meatshop.pb_pos_meatshop.p_ret_cashier_session.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_ret_cashier_session.sql
echo 'setup pb_pos_meatshop.p_save_new_product.sql'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_save_new_product.sql
echo 'setup pb_pos_meatshop.p_select_pending_lists'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_select_pending_lists.sql
echo 'setup pb_pos_meatshop.p_update_product'
mysql -u $master_user -h $master_host -P $master_port --password=$master_password < ../db/p/pb_pos_meatshop.p_update_product.sql




