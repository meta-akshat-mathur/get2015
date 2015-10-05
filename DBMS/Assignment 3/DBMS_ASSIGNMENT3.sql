USE lis;

-- 1.1-- display details of that books which is not returned ithin two months
SELECT m.member_name, bi.member_id, t.title_name, bi.accession_no, bi.issue_date, bi.due_date, 
PERIOD_DIFF(date_format(curdate(),'%Y%m'),date_format(bi.issue_date,'%Y%m')) As Issued_Months
FROM book_issue bi
INNER JOIN members m
ON  bi.member_id = m.member_id
INNER JOIN books b
ON bi.accession_no = b.accession_no
INNER JOIN titles t
ON b.title_id = t.title_id
Where(PERIOD_DIFF(date_format(curdate(),'%Y%m'),date_format(bi.issue_date,'%Y%m'))>=2);



-- 1.2 dispay members informations which have maximum length in member name
SELECT member_name,MAX(LENGTH(member_name)) AS MAXIMUM_LENGTH 
FROM members;

-- 1.3 count number of books issued
SELECT COUNT(accession_no) AS NUMBER_OF_BOOKS_ISSUED 
FROM book_issue;


-- 2.1 -- dispalay subject name, subject id and number of books purched of that subject
SELECT s.subject_name,s.subject_id ,count(t.subject_id) as no_of_books 
FROM subjects s INNER JOIN titles t ON s.subject_id=t.subject_id INNER JOIN books b ON t.title_id = b.title_id
WHERE b.status = 'Booked'
GROUP BY t.subject_id;

-- 2.2 display information of that books which is issued for more than two months
SELECT * 
FROM book_issue R 
WHERE (period_diff(date_format(R.due_date, '%Y%m'), date_format(R.issue_date, '%Y%m'))) > 2;



-- 2.3 list of books which have price greater than minimum price
SELECT t.title_name, b.price
FROM Books b, Titles t
WHERE b.title_id = t.title_id AND b.price > (SELECT MIN(b1.price)
                    FROM Books b1);


-- 3.1 display total no of students, no of faculties and no of others in library
SELECT category,COUNT(*) AS total
FROM Members
GROUP BY category;

-- 3.2 display those titles which have issued more than two times
SELECT b.accession_no, t.title_name
FROM Book_issue b, Books b1, Titles t
WHERE b.accession_no = b1.accession_no AND t.title_id = b1.title_id
GROUP BY b.accession_no
HAVING COUNT(b.accession_no) >= 2;



-- 3.3 display members which are issue any books but not belongs two F category
SELECT m.member_id, m.member_name, b.accession_no, t.title_name
FROM Book_issue b, Books b1, Members m, Titles t
WHERE b.accession_no = b1.accession_no AND t.title_id = b1.title_id AND b.member_id = m.member_id AND m.category != 'F';


-- 3.4 display those authors that book has been purchased
SELECT DISTINCT au_fname
FROM Authors  a, Titles t, Books b, Title_author ta
WHERE a.author_id = ta.author_id AND ta.title_id = t.title_id AND t.title_id = b.title_id;



