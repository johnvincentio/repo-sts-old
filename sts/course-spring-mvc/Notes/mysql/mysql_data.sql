
set FOREIGN_KEY_CHECKS = 0;

delete from category;
delete from product;
delete from customer;
delete from purchase;
delete from purchaseitem;

insert into category (id, name, description) 
values (default, 'Truffles', 'Truffles');
insert into category (id, name, description) 
values (default, 'Belgian Chocolates', 'Belgian Chocolates');

insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 1, 'Dark Chocolate Truffle', true, 'img_path', 20, 'Dark Chocolate Truffle');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 1, 'White Chocolate Truffle', true, 'img_path', 20, 'White Chocolate Truffle');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 1, 'Milk Chocolate Truffle with Cocoa', false, 'img_path', 20, 'Milk Chocolate Truffle with Cocoa');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 1, 'Almond Truffle', false, 'img_path', 20, 'Almond Truffle');

insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 2, 'description', true, 'img_path', 20, 'Peanut Clusters');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 2, 'description1', true, 'img_path1', 20, 'English Toffee');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 2, 'description', false, 'img_path', 20, 'Dark Chocolate (Box)');
insert into product (id, category, description, featured, image_path, price, product_name) 
values (default, 2, 'description1', false, 'img_path1', 20, 'Glace Apricot');


insert into customer (id, email, first_name, last_name, password, phone, name) 
values (default, 'test@test.com', 'First', 'Last', 'test', '1234567890', 'testtest');
insert into customer (id, email, first_name, last_name, password, phone, name) 
values (default, 'test1@test.com', 'First', 'Last', 'test', '1234567890', 'adminUser');
insert into customer (id, email, first_name, last_name, password, phone, name) 
values (default, 'test1@test.com', 'First', 'Last', 'test', '1234567890', 'shopOwner');
insert into customer (id, email, first_name, last_name, password, phone, name) 
values (default, 'charlie@packtpub.com', 'Charlie', 'Bucket', 'charlie', '1234567890', 'charlie');


insert into purchase (id, completed, order_date, version, ordered_by) 
values (1, true, date('2016-01-21'), 1, 3);
insert into purchase (id, completed, order_date, version, ordered_by) 
values (2, true, date('2016-02-21'), 1, 3);
insert into purchase (id, completed, order_date, version, ordered_by) 
values (3, true, date('2016-03-21'), 1, 4);
insert into purchase (id, completed, order_date, version, ordered_by) 
values (4, false, date('2016-04-21'), 1, 4);

insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (1, date('2016-01-21'), 3, 1, 1, 1);
insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (2, date('2016-01-21'), 2, 1, 1, 1);

insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (3, date('2016-02-21'), 2, 1, 2, 2);
insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (4, date('2016-02-21'), 3, 1, 2, 2);

insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (5, date('2016-03-21'), 4, 1, 3, 3);
insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (6, date('2016-03-21'), 5, 1, 3, 3);

insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (7, date('2016-04-21'), 5, 1, 4, 4);
insert into purchaseitem (id, order_date, quantity, version, product, purchase) 
values (8, date('2016-04-21'), 4, 1, 4, 4);

set FOREIGN_KEY_CHECKS = 1;
