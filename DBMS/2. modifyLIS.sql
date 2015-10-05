USE LIS;

ALTER TABLE book_issue MODIFY COLUMN issue_date TIMESTAMP DEFAULT now(); 

DELIMITER //

CREATE TRIGGER modifyDate
BEFORE INSERT ON book_issue
FOR EACH ROW 
BEGIN
SET NEW.due_date = NOW() + INTERVAL 15 day;
END; //

DELIMITER ;

desc book_issue;