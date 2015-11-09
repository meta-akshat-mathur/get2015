CREATE DATABASE vehicle_management_system;
USE vehicle_management_system;
CREATE TABLE USER(
 userId INT PRIMARY KEY AUTO_INCREMENT,
 userName VARCHAR(50) UNIQUE,
 password VARCHAR(50)
);
INSERT INTO `vehicle_management_system`.`user` (`userId`, `userName`, `password`) VALUES (1, 'akshat@gmail.com', 'akshat');

INSERT INTO `vehicle_management_system`.`user` (`userId`, `userName`, `password`) VALUES (2, 'admin@gmail.com', 'admin');

CREATE TABLE vehicle (
    vehicle_id integer unsigned not null auto_increment primary key,
    make VARCHAR (50),
    model VARCHAR (50) unique,
    engineIncc INT,
    fuelCapacity INT,
    milage INT,
    price FLOAT,
    road_tax FLOAT,
    created_by VARCHAR(50),
    created_time timestamp);
    
ALTER TABLE `vehicle_management_system`.`vehicle` ADD COLUMN `image` BLOB NULL DEFAULT NULL  AFTER `created_time` ;

ALTER TABLE vehicle MODIFY image VARCHAR(500);   

CREATE TABLE car (
    vehicle_id INTEGER unsigned not null auto_increment,
    ac BOOLEAN, 
    power_stering BOOLEAN,
    accessory_kit BOOLEAN,
    FOREIGN KEY(vehicle_id) REFERENCES vehicle (vehicle_id) ON DELETE CASCADE ON UPDATE CASCADE);
