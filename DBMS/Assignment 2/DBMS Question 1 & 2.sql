use lis;

-- Query to find the columns of table members
SELECT * FROM members;

-- Query to find the member id,member name,category of table members
SELECT member_id,member_name, category FROM members;

-- Query to find the member id,member name,category of table members whose category = "f"
SELECT member_id,member_name, category FROM members WHERE category = 'f';

-- Query to find distinct category of table members
SELECT DISTINCT(category) FROM members;

-- Query to find the member id,member name of table members order by desc
SELECT member_id,member_name FROM members ORDER BY member_name DESC;

-- Query to find the title name,publisher name, subject id of table
SELECT title_name,e.pub_name, subject_Id FROM Titles t , Publishers e WHERE t.pub_id=e.pub_id;

-- Query to find the count of members of category
SELECT category,COUNT(*) From members GROUP BY category;

-- Query to find name of members to which akshat belongs
SELECT m1.member_name FROM members AS m1 JOIN members AS m2 ON m1.category = m2.category WHERE m2.member_name ="AKSHAT";

-- Query to find the status of return book and if returned  then place blank
SELECT issue_Date,member_Id,e.accession_No, IF( status = 0 , return_Date," " ) as Book_Returned FROM Books e,Book_Return f WHERE e. accession_No = f.accession_No;


-- Assignment 2
-- Query to  display results in ascending order of issue date and within issue date in ascending order of members name.

SELECT f.issue_Date, f.member_Id,f.accession_No,IF( e.status =0 , return_Date," " ) as Book_Returned from Books e,Book_Return f, Members m WHERE ((e. accession_No = f.accession_No )&&(f.member_Id=m.member_Id)) ORDER BY issue_date asc , member_Name asc;


