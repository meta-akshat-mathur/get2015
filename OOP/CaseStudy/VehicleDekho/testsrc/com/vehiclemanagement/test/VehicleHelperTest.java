package com.vehiclemanagement.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vehiclemanagement.helper.VehicleHelper;
import com.vehiclemanagement.model.Vehicle;

public class VehicleHelperTest {
	@Test
	public void testCreateCar() {
		Vehicle vehicle = VehicleHelper.createVehicle("Car","XUV", "2008");
		assertNotNull(vehicle);
		assertEquals("XUV", vehicle.getModel());
	}

	@Test
	public void testCreateBike() {
		Vehicle vehicle = VehicleHelper.createVehicle("Bike",
				"Pulsar", "2013");
		assertEquals("Pulsar", vehicle.getModel());
	}

}
