

USE LIS;
ALTER TABLE book_issue 
    DROP FOREIGN KEY book_issue1;
ALTER TABLE book_return 
    DROP FOREIGN KEY book_return1;
DROP TABLE members;
SHOW TABLES ;