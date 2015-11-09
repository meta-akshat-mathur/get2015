package com.vehiclemanagement.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Vehicle {

	// id is the id of the vehicle.
	private int id;
	// created_by is the name of creator of vehicle
	private String createdBy;

	// created_time is the time of creation of vehicle
	private Date createdTime;

	private String make;
	private String model;
	private String engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;
	private String imagePath;

	double calculateOnRoadPrice() {
		return (price + roadTax);
	}

}
