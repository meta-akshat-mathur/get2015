package com.vehiclemanagement.model;

import lombok.Data;

@Data
public class Bike extends Vehicle {

	private boolean selfStart;
	private int helmetPrice;
	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0;
		if (isSelfStart()) {
			onRoadPrice = onRoadPrice + 1000;

		}

		onRoadPrice = onRoadPrice + getHelmetPrice();
		return super.calculateOnRoadPrice() + onRoadPrice;
	}

}