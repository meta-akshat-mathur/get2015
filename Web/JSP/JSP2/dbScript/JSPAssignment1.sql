CREATE DATABASE User_Details;

USE User_Details;

CREATE TABLE Registration(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    email VARCHAR(50)
);
