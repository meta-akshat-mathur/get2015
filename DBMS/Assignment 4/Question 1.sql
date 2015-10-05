
-- Assignment 1
/* 1.1 Write a SELECT command to display name of those members who belong 
to the category as to which member “Keshav Sharma” belongs. */
SELECT member_name 
FROM members 
WHERE category= (SELECT category FROM members WHERE member_name='Keshav Sharma');


/* 1.2 Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date. */
SELECT bi.Issue_date, t.Title_name, m.Member_name, bi.Due_date
FROM Book_Issue bi
INNER JOIN Books b 
ON b.Accession_no = bi.Accession_no
INNER JOIN Titles t 
ON t.Title_id = b.Title_id
INNER JOIN Members m 
ON m.Member_id = bi.Member_id
WHERE
NOT EXISTS(SELECT br.member_id, br.issue_date, br.accession_no
FROM book_return br
WHERE br.issue_date = DATE(bi.issue_date) AND br.member_id = bi.member_id AND br.accession_no = bi.accession_no);


/* 1.3 Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date. */
SELECT bi.Issue_date, t.Title_name, m.Member_name, bi.Due_date
FROM Book_Issue bi
INNER JOIN Books b 
ON b.Accession_no = bi.Accession_no
INNER JOIN Titles t 
ON t.Title_id = b.Title_id
INNER JOIN Members m 
ON m.Member_id = bi.Member_id
WHERE EXISTS( SELECT br.member_id, br.issue_date, br.accession_no
                FROM book_return br
                WHERE
                br.issue_date = DATE(bi.issue_date) AND br.member_id = bi.member_id 
                AND br.accession_no = bi.accession_no 
                AND br.Return_date > bi.Due_Date);
                
                
/* 1.4 Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far. */
SELECT accession_no,title_id,purchase_date,price,status
FROM Books
WHERE Price = (SELECT MAX(PRICE)
          FROM Books WHERE status='BOOKED');

/* 1.5 Write a SELECT command to display the second maximum price
of a book. */
SELECT accession_no,title_id,purchase_date,price,status
FROM Books
WHERE Price = (SELECT MAX(PRICE)
    FROM Books WHERE Price < (SELECT MAX(PRICE) FROM Books));

