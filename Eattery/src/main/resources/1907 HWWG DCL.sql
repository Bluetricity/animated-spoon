drop user TheTraveller cascade;
create user TheTraveller
identified by Kobolds7
default tablespace users
temporary tablespace temp
quota 10m on users;


grant connect to TheTraveller;
grant resource to TheTraveller;

grant create session to TheTraveller;

grant create table to TheTraveller;
grant create view to TheTraveller;