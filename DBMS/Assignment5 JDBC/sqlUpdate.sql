INSERT INTO `lis`.`members` (`member_id`, `member_name`, `address_line1`, `address_line2`, `category`) 
VALUES (5, 'Rahul Gupta', 'Mansarovar', 'Jaipur', 'S');

INSERT INTO `lis`.`book_issue` (`issue_date`, `accession_no`, `member_id`, `due_date`) 
VALUES ('2013-09-10 13:15:15', 20, 1, '2016-10-25');

INSERT INTO `lis`.`books` (`accession_no`, `title_id`, `purchase_date`, `price`, `status`) 
VALUES (50, 4, '2012-07-11', 400, 'Booked');

