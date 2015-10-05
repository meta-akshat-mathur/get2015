
-- Assignment 2
/* 2.1 Create a View which can be used to display member name and all issue details
       of the member using a simple SELECT command.
*/
CREATE VIEW BookIssueDetails
AS
SELECT m.member_name,B.issue_date,B.accession_no,B.member_id,B.due_date
FROM members M
INNER JOIN Book_issue B
ON M.member_id=B.member_id;

/* 2.2 Create a View which contains three columns, member name,member id and full description of category, 
i.e., Faculty, Students and Others instead of F,S and O.
*/
CREATE VIEW MemberTable
AS
SELECT member_id,member_name,if(category='S','Students',if(category='F','Faculty','Others')) AS Category
FROM members;


/* 2.3 Create a View which contains three columns, member name,
       member id and full description of category, i.e., Faculty, Students
       and Others instead of F,S and O.
*/
CREATE VIEW BooksInformation
AS
SELECT S.subject_name,T.title_name,BI.issue_date,BI.due_date,IFNULL(BR.return_date,'NULL') AS RETURN_DATE
FROM subjects S
LEFT OUTER JOIN titles T
ON S.subject_id=T.subject_id
LEFT OUTER JOIN Books
ON T.title_id=Books.title_id
LEFT OUTER JOIN book_issue BI
ON BI.accession_no=Books.accession_no
LEFT OUTER JOIN book_return BR
ON BR.accession_no=BI.accession_no;
