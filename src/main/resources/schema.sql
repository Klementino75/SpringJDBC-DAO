CREATE SCHEMA IF NOT EXISTS netology;

CREATE TABLE IF NOT EXISTS netology.CUSTOMERS (
    id           BIGSERIAL    PRIMARY KEY NOT NULL,
    name         VARCHAR(50)  NOT NULL,
    surname      VARCHAR(100) NOT NULL,
    age          INT          CHECK (age > 0 AND age < 150),
    phone_number VARCHAR(20)  NOT NULL);

CREATE TABLE IF NOT EXISTS netology.ORDERS (
     id           BIGSERIAL    PRIMARY KEY,
     date         DATE         NOT NULL,
     customer_id  INT          NOT NULL,
     product_name VARCHAR(128) NOT NULL,
     amount       INT          CHECK (amount > 0) NOT NULL,
     FOREIGN KEY (customer_id) REFERENCES netology.CUSTOMERS (id));