CREATE SCHEMA IF NOT EXISTS public;


CREATE TABLE IF NOT EXISTS persons (
    name           VARCHAR(32) NOT NULL,
    surname        VARCHAR(32) NOT NULL,
    age            INTEGER      NOT NULL,
    phone_number   VARCHAR(20)  NOT NULL,
    city_of_living VARCHAR(32)  NOT NULL,
    CONSTRAINT pk PRIMARY KEY (name, surname, age)
);

INSERT INTO persons(name, surname, age, phone_number, city_of_living)
VALUES
('Vasia', 'Vasiliev', 20, '+7123456789', 'Moscow'),
('Ivan', 'Ivanov', 30, '+7123456722', 'Sochi'),
('Petr', 'Petrov', 40, '+7555555555', 'Magadan');