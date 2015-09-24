package com.vehiclemanagement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vehiclemanagement.helper.VehicleHelper;
import com.vehiclemanagement.model.Bike;
import com.vehiclemanagement.model.Car;
import com.vehiclemanagement.model.Vehicle;

public class VehicleDetailPrinterTest {
 
	@Test
	public void VehicleHelperTestForCarInstance() {
		Vehicle vehicle = VehicleHelper.createVehicle("Car", "Sedan", "2008");
		assertEquals(true, vehicle instanceof Car);
	}

	@Test
	public void VehicleHelperTestForBikeInstance() {
		Vehicle vehicle = VehicleHelper.createVehicle("Bike", "CafeRacer", "2008");
		assertEquals(true, vehicle instanceof Bike);
	}

	}
