USE lis;
/*updating address*/
SET SQL_SAFE_UPDATES = 0;
UPDATE members
SET address_line2 ='JAIPUR'
WHERE member_id=member_id;

/*Updating member table*/
UPDATE members
SET address_line1='EPIP,Sitapura'
WHERE category='F';


/*Deleting publisher table*/
DELETE FROM publishers;

/*Setting substitution variables*/
SET @pub_id_inp1=55, @pub_name_inp1='Schaum Series',@pub_city1='Ajmer',
@pub_id_inp2=66, @pub_name_inp2='Tata MacGraw Hills',@pub_city2='Alwar',
@pub_id_inp3=77, @pub_nm_inp3='Genius',@pub_city3='Jaipur';

/*inserting into publishers table using substitution variables*/
INSERT INTO publishers VALUES(@pub_id_inp1,@pub_nm_inp1,@pub_city1);
INSERT INTO publishers VALUES(@pub_id_inp2,@pub_nm_inp2,@pub_city2);
INSERT INTO publishers VALUES(@pub_id_inp3,@pub_nm_inp3,@pub_city3);

DELETE FROM titles
WHERE pub_id=1;