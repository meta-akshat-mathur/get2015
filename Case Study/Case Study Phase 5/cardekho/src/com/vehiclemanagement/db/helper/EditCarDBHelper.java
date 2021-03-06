package com.vehiclemanagement.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vehiclemanagement.db.ConnectionFactory;
import com.vehiclemanagement.exceptions.MetaCRMSystemException;
import com.vehiclemanagement.model.Car;

public class EditCarDBHelper extends EditVehicleDBHelper {
	private static String UPDATE_CAR_QUERY = "UPDATE car SET  ac=?, power_stering=?, accessory_kit=? WHERE car_id=?";

	private static String SELECT_FOR_CAR_ID_QUERY = "SELECT car_id FROM car WHERE vehicle_id=?";

	public int create(Connection connection,Car objCar, String oldMake, String oldModel)
			throws MetaCRMSystemException {
		int created = -1;
		if (connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				// get the vehicle id of the vehicle to be updated
				int vehicleId = super.create(connection, objCar, oldMake,
						oldModel);
				//gets the car id of the car to be updated
				int carId = getCarIdByVehicleId(connection, vehicleId);
				if (carId > 0) {
					preparedStatement = connection
							.prepareStatement(UPDATE_CAR_QUERY);
					preparedStatement.setBoolean(1, objCar.isAC());
					preparedStatement.setBoolean(2, objCar.isPowerSteering());
					preparedStatement.setBoolean(3, objCar.isAccessoryKit());
					preparedStatement.setInt(4, carId);
					created = preparedStatement.executeUpdate();
				}
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaCRMSystemException("Could not update car, ["
						+ e.getMessage() + "]");
			} finally {
				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out
								.println("Could not close prepared statement, ["
										+ e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		return created;
	}

	//function used to get the car id from the car table by vehicle id
	protected int getCarIdByVehicleId(Connection connection, int vehicleId)
			throws MetaCRMSystemException {
		int carId = -1;
		if (connection != null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection
						.prepareStatement(SELECT_FOR_CAR_ID_QUERY);
				preparedStatement.setInt(1, vehicleId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					carId = resultSet.getInt(1);
				}
			} catch (SQLException e) {
				throw new MetaCRMSystemException(
						"Could not find car id by vehicle id, ["
								+ e.getMessage() + "]");
			}
		}
		return carId;
	}
}
