--liquibase formatted sql
--changeset DixieDean:1

insert into my_default.persons(name, surname, age, phone_number, city_of_living, order_product_id)
VALUES ('Grettir', 'Asmundson', 25, '+79109562719', 'Oslo', 1);
insert into my_default.persons(name, surname, age, phone_number, city_of_living, order_product_id)
VALUES ('Erika', 'Haas', 21, '+79109562864', 'Berlin', 2);
insert into my_default.persons(name, surname, age, phone_number, city_of_living, order_product_id)
VALUES ('Aleksandr', 'Orlov', 27, '+79109562534', 'Moscow', 3);