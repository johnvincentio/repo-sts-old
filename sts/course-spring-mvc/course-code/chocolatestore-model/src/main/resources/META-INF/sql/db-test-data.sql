insert into category (id, name, description) values (default, 'Truffles', 'Truffles')
insert into category (id, name, description) values (default, 'Belgian Chocolates', 'Belgian Chocolates')
insert into product (id, category, description, featured, image_path, price, name) values (default, 1, 'Dark Chocolate Truffle', true, 'img_path', 20, 'Dark Chocolate Truffle')
insert into product (id, category, description, featured, image_path, price, name) values (default, 1, 'White Chocolate Truffle', true, 'img_path', 20, 'White Chocolate Truffle')
insert into product (id, category, description, featured, image_path, price, name) values (default, 1, 'Milk Chocolate Truffle with Cocoa', true, 'img_path', 20, 'Milk Chocolate Truffle with Cocoa')
insert into product (id, category, description, featured, image_path, price, name) values (default, 1, 'Almond Truffle', true, 'img_path', 20, 'Almond Truffle')


insert into product (id, category, description, featured, image_path, price, name) values (default, null, 'description', true, 'img_path', 20, 'Peanut Clusters')
insert into product (id, category, description, featured, image_path, price, name) values (default, null, 'description1', true, 'img_path1', 20, 'English Toffee')
insert into product (id, category, description, featured, image_path, price, name) values (default, null, 'description', true, 'img_path', 20, 'Dark Chocolate (Box)')
insert into product (id, category, description, featured, image_path, price, name) values (default, null, 'description1', true, 'img_path1', 20, 'Glace Apricot')


insert into customer (id, email, first_name, last_name, password, phone, name) values (default, 'test@test.com', 'First', 'Last', 'test', '1234567890', 'testtest')
insert into customer (id, email, first_name, last_name, password, phone, name) values (default, 'test1@test.com', 'First', 'Last', 'test', '1234567890', 'adminUser')
insert into customer (id, email, first_name, last_name, password, phone, name) values (default, 'test1@test.com', 'First', 'Last', 'test', '1234567890', 'shopOwner')
insert into customer (id, email, first_name, last_name, password, phone, name) values (default, 'charlie@packtpub.com', 'Charlie', 'Bucket', 'charlie', '1234567890', 'charlie')