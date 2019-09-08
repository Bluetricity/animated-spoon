drop table TRANSACTIONITEMS cascade constraints;
drop table ITEMTRANSACTION cascade constraints;
drop table LOCATIONS cascade constraints;
drop table CUSTOMERS cascade constraints;
drop table STOCK_MENU cascade constraints; 
drop table MENU cascade constraints;
drop table STOCK cascade constraints;
drop table EMPLOYEE cascade constraints;
drop table MENU_TYPE cascade constraints;

drop sequence CUSTOMER_SEQ;
drop sequence EMPLOYEE_SEQ;
drop sequence MENU_SEQ;
drop sequence STOCK_SEQ;
drop sequence TRANSACTION_SEQ;
drop sequence LOCATION_SEQ;
drop sequence MENU_TYPE_SEQ;

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

create table Menu_Type (
    MTID number(20) primary key,
    Menu_name varchar2(30) not null
);

create table Menu (
    MID number(20) primary key,
    MTID number(20) not null,
    MealName varchar2(40),
    Price number(15),
    Description varchar2(100),
    constraint fk_Menu_type foreign key (MTID) references Menu_Type(MTID) on delete cascade
);

create table Stock_Menu (
    SID number(20),
    MID number(20),
    amount number(15),
    constraint fk_Stock_Menu foreign key (MID) references Menu(MID) on delete cascade,
    constraint fk_Menu_Stock foreign key (SID) references Stock(SID) on delete cascade
);

create table Customers (
    CID number(20) primary key,
    Username varchar2(20) UNIQUE,
    Password varchar2(20) not null,
    Name varchar2(20) not null,
    ContactInfo varchar2(30) not null
);

create table Locations (
	LID number(20) primary key,
    CID number(20) not null,
    Address varchar2(60) not null,
    constraint fk_address_user foreign key (CID) references Customers(CID)on delete cascade
);

create table ItemTransaction (
    TID number(20) primary key,
    CID number(20) not null,
    Payment_type varchar2(30) not null,
    Status number(1,0) not null,
    constraint fk_customer_user foreign key (CID) references Customers(CID) on delete cascade
);

create table TransactionItems (
    TID number(20) not null, 
    MID number(20) not null,
    Quanity number(5,2),
    constraint fk_item_transaction foreign key (TID) references ItemTransaction(TID) on delete cascade,
    constraint fk_item_menuitem foreign key (MID) references Menu(MID) on delete cascade
);

create sequence employee_seq;
create sequence stock_seq;
create sequence menu_seq;
create sequence customer_seq;
create sequence transaction_seq;
create sequence location_seq;
create sequence menu_type_seq;

