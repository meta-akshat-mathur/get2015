CREATE DATABASE LIS;

USE LIS;
CREATE TABLE authors (author_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
au_lname VARCHAR(10),
au_fname VARCHAR(10) NOT NULL,
address VARCHAR(50),
city VARCHAR(30) NOT NULL,
state VARCHAR(30));

CREATE TABLE publishers (pub_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
pub_name VARCHAR(50) NOT NULL,
city VARCHAR(30));

CREATE TABLE subjects (subject_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(30));

CREATE TABLE titles (title_id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
title_name VARCHAR(30),
purchase_date DATE NOT NULL,
pub_id INTEGER,
FOREIGN KEY(pub_id) REFERENCES publishers(pub_id));

CREATE TABLE title_author(author_id INTEGER,
title_id INTEGER,
FOREIGN KEY(author_id) REFERENCES authors(author_id),
FOREIGN KEY(title_id) REFERENCES titles(title_id),
PRIMARY KEY(author_id,title_id));

CREATE TABLE books(accession_no INTEGER PRIMARY KEY,
title_id INTEGER,
purchase_date DATE,
price INTEGER,
status VARCHAR(20),
CONSTRAINT title_key FOREIGN KEY(title_id) REFERENCES titles(title_id));

CREATE TABLE members (member_id INTEGER NOT NULL PRIMARY KEY,
member_name VARCHAR(30),
address_line1 VARCHAR(50),
address_line2 VARCHAR(50),
category VARCHAR(30));

CREATE TABLE book_issue (issue_date TIMESTAMP NOT NULL,
accession_no INTEGER NOT NULL,
member_id INTEGER NOT NULL,
due_date DATE,
CONSTRAINT book_issue1 FOREIGN KEY(member_id) REFERENCES members(member_id) on delete cascade,
CONSTRAINT accession_key FOREIGN KEY(accession_no) REFERENCES books(accession_no) on delete cascade,
PRIMARY KEY(issue_date,member_id,accession_no));

CREATE TABLE book_return(return_date DATE NOT NULL,
accession_no INTEGER,
member_id INTEGER,
issue_date DATE,
CONSTRAINT book_return1 FOREIGN KEY(member_id) REFERENCES members(member_id) on delete cascade,
FOREIGN KEY(accession_no) REFERENCES books(accession_no) on delete cascade,
PRIMARY KEY(return_date,accession_no,member_id));


SHOW TABLES;















