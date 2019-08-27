drop table TRANSACTIONITEMS cascade constraints;
drop table TRANSACTION cascade constraints;
drop table LOCATIONS cascade constraints;
drop table CUSTOMERS cascade constraints;
drop table STOCK_MENU cascade constraints; 
drop table MENU cascade constraints;
drop table STOCK cascade constraints;
drop table EMPLOYEE cascade constraints;

drop sequence CUSTOMER_SEQ;
drop sequence EMPLOYEE_SEQ;
drop sequence MENU_SEQ;
drop sequence STOCK_SEQ;
drop sequence TRANSACTION_SEQ;

create table Employee (
    EID number(20) primary key,
    username varchar2(20) Unique,
    password varchar2(20) not null,
    empName varchar2(30) not null,
    title varchar2(30) not null
);

create table Stock (
    SID number(20) primary key,
    Ingredient_name varchar2(40),
    Quantity_Stored number(10,2)
);

create table Menu (
    MID number(20) primary key,
    MealName varchar2(40),
    Price number(15)
);

create table Stock_Menu (
    SID number(20),
    MID number(20) primary key,
    amount number(15)
);

create table Customers (
    CID number(20) primary key,
    Username varchar2(20) UNIQUE,
    Password varchar2(20) not null,
    Name number(20) not null,
    ContactInfo varchar2(30) not null
);

create table Locations (
    CID number(20) not null,
    Address varchar2(60) not null,
    constraint fk_address_user foreign key (CID) references Customers(CID)
);

create table Transaction (
    TID number(20) primary key,
    CID number(20) not null,
    Payment_type varchar2(30) not null
);

create table TransactionItems (
    TID number(20) not null, 
    MID number(20) not null,
    Quanity number(5,2),
    constraint fk_item_transaction foreign key (TID) references Transaction(TID),
    constraint fk_item_menuitem foreign key (MID) references Menu(MID)
);

create sequence employee_seq;
create sequence stock_seq;
create sequence menu_seq;
create sequence customer_seq;
create sequence transaction_seq;

