--liquibase formatted sql
--changeset DixieDean:2

insert into my_default.orders(product_name, amount, product_id)
VALUES ('Sword', 12, 1);
insert into my_default.orders(product_name, amount, product_id)
VALUES ('Redmi Note 12', 1, 2);
insert into my_default.orders(product_name, amount, product_id)
VALUES ('Keyboard', 2, 3);