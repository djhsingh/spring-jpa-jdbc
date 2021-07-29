create table person(
id integer not null primary key auto_increment,
name varchar(200),
location varchar(200),
birth_date timestamp
);
insert into PERSON (name, location, birth_date) values ('raj', 'punjab', CURRENT_TIMESTAMP);
insert into PERSON (name, location, birth_date) values ('sonu', 'haryana', CURRENT_TIMESTAMP);
insert into PERSON (name, location, birth_date) values ('amit', 'delhi', CURRENT_TIMESTAMP);
insert into PERSON (name, location, birth_date) values ('djh', 'goa', CURRENT_TIMESTAMP);