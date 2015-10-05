/*Creating member table again*/

USE LIS;
CREATE TABLE members (member_id INTEGER NOT NULL PRIMARY KEY,
member_name VARCHAR(30),
address_line1 VARCHAR(50),
address_line2 VARCHAR(50),
category VARCHAR(30));

ALTER TABLE book_issue 
    ADD CONSTRAINT book_issue2 
        FOREIGN KEY(member_id) REFERENCES members(member_id);
ALTER TABLE book_return 
        ADD CONSTRAINT book_issue1 
            FOREIGN KEY(member_id) REFERENCES members(member_id);
SHOW TABLES ;