create table countries(
    id int not null primary key,
    name varchar(50) not null
);

create table continents(
    id int not null primary key,
    name varchar(20) not null
);

--jdbc:oracle:thin:@localhost:1521:XE