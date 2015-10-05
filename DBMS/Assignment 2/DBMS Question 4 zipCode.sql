-- Creating Database zipcodeInfo
CREATE DATABASE zipcodeInfo;
USE zipcodeInfo;


-- Creating table cityInfo
CREATE TABLE cityInfo
(
	-- To store zip code and name
	city_ID int PRIMARY KEY AUTO_INCREMENT,
    zipcode int NOT null,
	cityName varchar(20)
);
-- Creating table stateInfo
CREATE TABLE stateInfo
(
	-- to store zipcode and stateName
	state_ID int PRIMARY KEY AUTO_INCREMENT ,
	stateName varchar(20),
  city_ID INT,
	FOREIGN KEY (city_ID) REFERENCES cityInfo(city_ID) 
);
  
 -- Inserting values in cityInfo table
 INSERT INTO cityInfo(city_ID,zipcode,cityName) VALUES (101,305001,'ajmer');
 INSERT INTO cityInfo(zipcode,cityName) VALUES (305002,'jaipur');
 INSERT INTO cityInfo(zipcode,cityName) VALUES (305003,'delhi');
 
 -- Inserting values in stateInfo table
 INSERT INTO stateInfo(state_ID,stateName,city_ID) VALUES (1,'rajasthan',101);
 INSERT INTO stateInfo(stateName,city_ID) VALUES ('rajasthan',102);
 INSERT INTO stateInfo(stateName,city_ID) VALUES ('delhi',103);
 
 
 -- Query to find the zip code city name and stateName
 SELECT c.zipcode,c.cityName,s.stateName FROM cityInfo c, stateInfo s WHERE c. city_ID=s.city_ID ORDER BY stateName asc , cityName asc;

 
 
 
 