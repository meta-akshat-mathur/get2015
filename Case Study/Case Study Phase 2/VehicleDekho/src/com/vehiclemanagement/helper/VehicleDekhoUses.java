package com.vehiclemanagement.helper;

import java.util.List;

import com.vehiclemanagement.JDBC.InsertIntoVechileDekhoTables;
import com.vehiclemanagement.model.Vehicle;

public class VehicleDekhoUses {

	public static void main(String[] args) {
		InsertIntoVechileDekhoTables insert = new InsertIntoVechileDekhoTables();
		StaXParser st = new StaXParser();
		//Reading Data from XML files
		List<Vehicle> cars = st
				.readConfig("../VehicleDekho/XMLfiles/carinput.xml");
		//System.out.println(cars);
		List<Vehicle> bikes = st
				.readConfig("../VehicleDekho/XMLfiles/bikeinput.xml");
		//System.out.println(bikes);

		for (Vehicle carVehicle : cars)
			insert.insertIntoVehicle(carVehicle);
		for (Vehicle bikeVehicle : bikes)
			insert.insertIntoVehicle(bikeVehicle);
	}

}
