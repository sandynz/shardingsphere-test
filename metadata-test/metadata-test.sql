
-- init database in MySQL
drop database if exists scaling_ds_10;
create database scaling_ds_10 default charset utf8;

drop database if exists scaling_ds_11;
create database scaling_ds_11 default charset utf8;

drop database if exists scaling_ds_12;
create database scaling_ds_12 default charset utf8;

-- create table in proxy
CREATE TABLE t_order (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, PRIMARY KEY (order_id));

CREATE TABLE t_order_item (item_id INT NOT NULL, order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, creation_date DATE, PRIMARY KEY (item_id));
