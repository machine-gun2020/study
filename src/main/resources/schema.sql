DROP TABLE IF EXISTS COUNTRIES;
CREATE TABLE COUNTRIES (
ID INT AUTO_INCREMENT PRIMARY KEY,
NAME VARCHAR(50) NOT NULL
);

drop table if exists sorteos;
create table sorteos (
ID int primary key,
n1 int,
n2 int,
n3 int,
n4 int,
n5 int,
n6 int,
comodin int,
fecha DATE,
monto long);