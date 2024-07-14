Drop DATABASE kade;
CREATE DATABASE kade;
USE kade;

CREATE TABLE Customer(
	id VARCHAR(6) NOT NULL primary key,
	name VARCHAR(30),
	address VARCHAR(30) NOT NULL,
	salary decimal(10,2) not null

);