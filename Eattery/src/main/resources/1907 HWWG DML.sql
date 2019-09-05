--Customers
insert into customers(cid, username, password, name, contactinfo)
values (customer_seq.nextval, 'cust1', 'pass', 'Steve Stevens', '123-456-7890');

insert into customers(cid, username, password, name, contactinfo)
values (customer_seq.nextval,'test2', 'pass', 'customer', '7894561230');

--Employee (one stocker, one cook, one delivery driver, one manager)
insert into employee(eid, username, password, empname, title)
values (employee_seq.nextval, 'stocker', 'pass', 'Generic Stocker', 'Stocker');
insert into employee(eid, username, password, empname, title)
values (employee_seq.nextval, 'chef', 'pass', 'the chef', 'Cook');
insert into employee(eid, username, password, empname, title)
values (employee_seq.nextval, 'delivery', 'pass', 'Delivery Driver', 'Delivery Driver');
insert into employee(eid, username, password, empname, title)
values (employee_seq.nextval, 'manager', 'pass', 'manager', 'Manager');

--location
insert into locations(lid, cid, address)
values(LOCATION_SEQ.nextval, 1, '123 main st.');
insert into locations(lid, cid, address)
values(LOCATION_SEQ.nextval, 1, '321 address street');
insert into locations(lid, cid, address)
values(LOCATION_SEQ.nextval, 2, '231 street street');

--menu
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'chicken tenders', 6.99, 'spend those saved up goodboy points on these out of this world tendies');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'french fries', 3.99, 'imagine regular fries, but french. oui');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'salad', 5.99, 'it`s healthy tho');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'hamburger', 8.99, 'see cheeseburger, just without the cheese');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'cheeseburger', 8.99, 'see hamburger, but with cheese');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'chicken wings', 7.99, 'this is a lie. there`s actually more than just wings lol');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'steak', 15.99, 'steak. it`s pretty good tbh');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'mashed potatoes', 4.99, 'potatoes, but mashed');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'mac and cheese', 6.99, 'poor mac and his friend cheese. we knew them well');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'fish', 10.99, 'lol idk what kind');
insert into menu(mid, mealname, price, description)
values(menu_seq.nextval, 'lobster', 15.99, 'bruh');

--stock
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'chicken', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'lettuce', 80);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'macaroni', 30);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'cheese', 60);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'beef', 80);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'potato', 100);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'fish', 30);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'lobster', 20);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (stock_seq.nextval, 'tomato', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values(stock_seq.nextval, 'onion', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values(stock_seq.nextval, 'bread', 70);

--stock_menu
--chicken tenders
insert into stock_menu(sid, mid, amount)
values (1, 1, 30);
--french fries
insert into stock_menu(sid, mid, amount)
values (6, 2, 80);
--salad
insert into stock_menu(sid, mid, amount)
values (2,3,60);
--hamburger
insert into stock_menu(sid, mid, amount)
values (5,4,30);
--cheeseburger
insert into stock_menu(sid, mid, amount)
values (5,5,30);
--wings
insert into stock_menu(sid, mid, amount)
values (1,6,20);
--steak
insert into stock_menu(sid, mid, amount)
values (5,7,20);
--mashed potatoes
insert into stock_menu(sid, mid, amount)
values (6,8,20);
--mac&cheese
insert into stock_menu(sid, mid, amount)
values (3,9,30);
--fish
insert into stock_menu(sid, mid, amount)
values (7,10,30);
--lobster
insert into stock_menu(sid, mid, amount)
values (8,11,20);

--transaction
-- 0 = pending, 1 = accepted, 2 = rejected
insert into itemtransaction (tid, cid, payment_type, status)
values(transaction_seq.nextval, 1, 'card', 0);
insert into itemtransaction (tid, cid, payment_type, status)
values(transaction_seq.nextval,2, 'cash', 1);
insert into itemtransaction (tid, cid, payment_type, status)
values(transaction_seq.nextval, 1, 'cash', 2);

--transactionitems
insert into transactionitems(tid, mid, quanity)
values (1, 1, 1);
insert into transactionitems(tid, mid, quanity)
values (2, 2, 1);

commit work;