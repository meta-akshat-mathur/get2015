package com.vehiclemanagement.model;

import lombok.Data;

@Data
public class Car extends Vehicle {

	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;

	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0.0;
		if (this.isAC()) {
			onRoadPrice = onRoadPrice + 5000;

		}

		if (isAccessoryKit()) {
			onRoadPrice = onRoadPrice + 10000;

		}

		if (isPowerSteering()) {
			onRoadPrice = onRoadPrice + 3000;

		}

		return super.calculateOnRoadPrice() + onRoadPrice;
	}
}
