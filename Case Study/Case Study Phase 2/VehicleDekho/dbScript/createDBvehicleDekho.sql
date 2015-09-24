CREATE DATABASE vehiclemanagement;
USE vehiclemanagement;
CREATE TABLE vehicle (
    vehicleId DOUBLE PRIMARY KEY,
    make VARCHAR (50),
    model VARCHAR (50),
    engineInCC INT,
    fuelCapacity INT,
    mileage INT,
    price FLOAT,
    roadTax FLOAT);

CREATE TABLE car (
    vehicleId DOUBLE,
    ac BOOLEAN, 
    powerSteering BOOLEAN,
    accessoryKit BOOLEAN,
    FOREIGN KEY(vehicleId) REFERENCES vehicle (vehicleId) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE bike (
    vehicleId DOUBLE,
    selfStart BOOLEAN,
    helmetprice FLOAT,
    FOREIGN KEY(vehicleId) REFERENCES vehicle (vehicleId) ON DELETE CASCADE ON UPDATE CASCADE);