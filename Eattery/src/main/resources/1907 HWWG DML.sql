--Customers
insert into customers(cid, username, password, name, contactinfo)
values (1, 'cust1', 'pass', 'Steve Stevens', '123-456-7890');

insert into customers(cid, username, password, name, contactinfo)
values (2,'test2', 'pass', 'customer', '7894561230');

--Employee (one stocker, one cook, one delivery driver, one manager)
insert into employee(eid, username, password, empname, title)
values (1, 'stocker', 'pass', 'Generic Stocker', 'Stocker');
insert into employee(eid, username, password, empname, title)
values (2, 'chef', 'pass', 'the chef', 'Cook');
insert into employee(eid, username, password, empname, title)
values (3, 'delivery', 'pass', 'Delivery Driver', 'Delivery Driver');
insert into employee(eid, username, password, empname, title)
values (4, 'manager', 'pass', 'manager', 'Manager');

--location
insert into locations(cid, address)
values(1, '123 main st.');
insert into locations(cid, address)
values(1, '321 address street');
insert into locations(cid, address)
values(2, '231 street street');

--menu
insert into menu(mid, mealname, price)
values(1, 'chicken tenders', 6.99);
insert into menu(mid, mealname, price)
values(2, 'french fries', 3.99);
insert into menu(mid, mealname, price)
values(3, 'salad', 5.99);
insert into menu(mid, mealname, price)
values(4, 'hamburger', 8.99);
insert into menu(mid, mealname, price)
values(5, 'cheeseburger', 8.99);
insert into menu(mid, mealname, price)
values(6, 'chicken wings', 7.99);
insert into menu(mid, mealname, price)
values(7, 'steak', 15.99);
insert into menu(mid, mealname, price)
values(8, 'mashed potatoes', 4.99);
insert into menu(mid, mealname, price)
values(9, 'mac and cheese', 6.99);
insert into menu(mid, mealname, price)
values(10, 'fish', 10.99);
insert into menu(mid, mealname, price)
values(11, 'lobster', 15.99);

--stock
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (1, 'chicken', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (2, 'lettuce', 80);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (3, 'macaroni', 30);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (4, 'cheese', 60);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (5, 'beef', 80);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (6, 'potato', 100);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (7, 'fish', 30);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (8, 'lobster', 20);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values (9, 'tomato', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values(10, 'onion', 50);
insert into stock (sid, INGREDIENT_NAME, QUANTITY_STORED)
values(11, 'bread', 70);

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
insert into transaction (tid, cid, payment_type)
values(1, 1, 'card');
insert into transaction (tid, cid, payment_type)
values(2,2, 'cash');

--transactionitems
insert into transactionitems(tid, mid, quanity)
values (1, 1, 1);
insert into transactionitems(tid, mid, quanity)
values (2, 2, 1);