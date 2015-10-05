USE lis;

/*Insert data into members table*/


INSERT INTO members (member_id,member_name,address_line1, address_line2, category)
 	VALUES ('1','AKSHAT MATHUR', 'EPIP', 'AJMER, rajasthan', 'S'
);

INSERT INTO members (member_id,member_name,address_line1, address_line2, category)
 	VALUES ('2','Keshav Sharma', 'Malviya nagar', 'jaipur, rajasthan', 'F'
);

INSERT INTO members (member_id,member_name,address_line1, address_line2, category)
 	VALUES ('3', 'NIkhil Tinker', 'EPIP', 'kota', 'F'
);

INSERT INTO members (member_id,member_name,address_line1, address_line2, category)
 	VALUES ('4', 'Sanjay Nainani', 'Civil lines', 'delhi', 'O'
);


/*Insert data into subjects table*/

INSERT INTO subjects (subject_id,
	`subject_name`)
	 VALUES (101,'DBMS'
);

INSERT INTO subjects (subject_id,
	`subject_name`)
	 VALUES (102,'Java'
);

INSERT INTO subjects (subject_id,
	`subject_name`)
	 VALUES (103,'DSA'
);
INSERT INTO subjects (subject_id,
	`subject_name`)
	 VALUES (104,'OS'
);

/*Insert data into publishers table*/
INSERT INTO publishers (pub_id,
	`pub_name`, `city`)
	 VALUES (1,'jaipur books','jaipur'
);

INSERT INTO publishers (pub_id,
	`pub_name`, `city`)
	 VALUES (2,'delhi books', 'delhi'
);

INSERT INTO publishers (pub_id,
	`pub_name`, `city`)
	 VALUES (3,'Ajmer books', 'Ajmer'
);



/*Insert into authors table*/

INSERT INTO authors (
	`au_fname`, `au_lname`,`address`,`city`,`state`)
	 VALUES ( 'mehul','sharma','sanganer','jaipur','Rajasthan'
);

INSERT INTO authors (
	`au_fname`, `au_lname`,`address`,`city`,`state`)
	 VALUES ( 'rahul','sharma','chaura rasta','jaipur','Rajasthan'
);

INSERT INTO authors (
	`au_fname`, `au_lname`,`address`,`city`,`state`)
	 VALUES ( 'akshat','mathur','sanganer','jaipur','Rajasthan'
);
INSERT INTO authors (
	`au_fname`, `au_lname`,`address`,`city`)
	 VALUES ( 'ravi','sharma','sanganer','delhi'
);


/*insert data into titles*/

INSERT INTO titles (
	 `title_name`, `purchase_date`,subject_id,pub_id)
	 VALUES ( 'DBMS', '2015-03-12',101,1
);
INSERT INTO titles (
	 `title_name`, `purchase_date`,subject_id,pub_id)
	 VALUES ( 'java', '2015-06-15',102,2
);
INSERT INTO titles (
	 `title_name`, `purchase_date`,subject_id,pub_id)
	 VALUES ( 'C++', '2015-04-12',103,3
);
INSERT INTO titles (
	 `title_name`, `purchase_date`,subject_id,pub_id)
	 VALUES ( 'Operating System', '2015-09-01',104,3
);

/*Insert into title_author*/
INSERT INTO title_author (author_id,
    title_id)
	VALUES (1,1
);
INSERT INTO title_author (author_id,
    title_id)
	VALUES (2,2
);
INSERT INTO title_author (author_id,
    title_id)
	VALUES (3,3
);


/*Insert into books*/

INSERT INTO books (accession_no,title_id,
	purchase_date, price, status)
	VALUES ('10',1,'2013-05-12', 320, 'Booked'
);
INSERT INTO books (`accession_no`,title_id,
	`purchase_date`, `price`, `status`)
	VALUES ('20',2,'2015-08-10', 550, 'UnBooked'
);
INSERT INTO books (`accession_no`,title_id,
	`purchase_date`, `price`, `status`)
	VALUES ('30',3,'2014-07-12', 880, 'Booked'
);
INSERT INTO books (`accession_no`,title_id,
	`purchase_date`, `price`, `status`)
	VALUES ('40',4,'2014-07-11', 1000, 'Booked'
);


/*Insert into book_issue*/

INSERT INTO book_issue (`issue_date`,`accession_no`,`member_id`,`due_date`) 
	VALUES ('2015-06-10 13:15:15','10','1','2015-12-25');
INSERT INTO book_issue (`issue_date`,`accession_no`,`member_id`,`due_date`) 
	VALUES ('2015-09-10 13:15:15', '10', '2', '2015-09-26');
INSERT INTO book_issue (`issue_date`,`accession_no`,`member_id`,`due_date`) 
	VALUES ('2015-09-10 13:15:15', '20', '2', '2015-09-25');
INSERT INTO book_issue (`issue_date`,`accession_no`,`member_id`,`due_date`) 
	VALUES ('2015-09-10 13:15:15', '30', '3', '2016-10-25');
INSERT INTO book_issue (`issue_date`,`accession_no`,`member_id`,`due_date`) 
	VALUES ('2015-08-10 13:15:15', '40', '4', '2015-09-29');

/*Insert into book_return*/
INSERT INTO book_return (`accession_no`,`member_id`,
	`return_date`,`issue_date`) 
	VALUES ('10','1','2015-09-19','2015-06-10'
);
INSERT INTO book_return (`accession_no`,`member_id`,
	`return_date`,`issue_date`) 
	VALUES ('20','2','2015-09-29','2015-09-10'
);
INSERT INTO book_return (`accession_no`,`member_id`,
	`return_date`,`issue_date`) 
	VALUES ('30','3','2015-09-20','2015-09-10'
);


