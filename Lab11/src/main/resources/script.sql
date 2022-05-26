create table users
(
    id   int primary key auto_increment,
    name varchar(100) not null unique
);

create table friends
(
    id       int primary key auto_increment,
    friend_1 int,
    friend_2 int,
    foreign key (friend_1) references users (id),
    foreign key (friend_2) references users (id)
);

drop table users;
drop table friends;

insert into users(id,name) values (1,'Andrei');
insert into users(id,name) values (2,'Crina');

insert into friends(friend_1, friend_2)
values (1, 2);

select u.id, count(*)
from users u
         join friends f on u.id = f.friend_1 or u.id = f.friend_2
group by u.id;

-- trigger pentru a verifica inainte de inserarea unei relatii
-- de prietenii daca acea relatie exista deja
CREATE TRIGGER before_insert_on_friends
    BEFORE INSERT
    ON friends
    FOR EACH ROW
BEGIN
    DECLARE row_count INT;

    SELECT COUNT(*)
    INTO row_count
    FROM friends
    where (friend_1 = new.friend_1 and friend_2 = new.friend_2)
       or (friend_2 = new.friend_1 and friend_1 = new.friend_2);

    IF row_count > 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'These users are already friends!';
END IF;

IF new.friend_1 = new.friend_2 THEN
        SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'The users need to be different!';
end if;

END;

drop trigger before_insert_on_friends;