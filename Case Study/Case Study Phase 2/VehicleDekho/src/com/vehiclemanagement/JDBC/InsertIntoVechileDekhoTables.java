package com.vehiclemanagement.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vehiclemanagement.model.Bike;
import com.vehiclemanagement.model.Car;
import com.vehiclemanagement.model.Vehicle;

public class InsertIntoVechileDekhoTables {
	/**
	 * Inserting data in tables
	 * @param vehicle class
	 * @return 
	 */
	public boolean insertIntoVehicle(Vehicle vehicle) {
		Connection con = null;
		PreparedStatement ps = null;
		int result;
		con = ConnectionUtil.getConnection();
		String query = "INSERT INTO vehicle (`vehicleId`, `make`, `model`, `engineInCC`, `fuelCapacity`,"
				+ " `mileage`, `price`, `roadTax`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, vehicle.getVehicleId());
			ps.setString(2, vehicle.getMake());
			ps.setString(3, vehicle.getModel());
			ps.setInt(4, vehicle.getEngineInCC());
			ps.setInt(5, vehicle.getFuelCapacity());
			ps.setInt(6, vehicle.getMileage());
			ps.setFloat(7, vehicle.getPrice());
			ps.setFloat(8, vehicle.getRoadTax());
			result = ps.executeUpdate();
			if (result != 0) {
				if (vehicle instanceof Car) {
					insertIntoCar(vehicle);
					return true;
				} else {
					insertIntoBike(vehicle);
					return true;
				}
			}
				//Handling exception for duplicate data insertion
		} catch (SQLException e) {
			System.out
					.println("Data having same vehicleID cannot be inserted in  again database ");

		} finally {

			try {
				if (ps != null) {
					ps.close();
				}
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Inserting data in car table
	 * @param vehicle
	 * @return
	 */
	private boolean insertIntoCar(Vehicle vehicle) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean result;
		con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Car (`vehicleId`, `ac`, `powerSteering`, `accessoryKit`)"
				+ " VALUES (?, ?, ?, ?); ";
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, vehicle.getVehicleId());
			ps.setBoolean(2, ((Car) vehicle).isAC());
			ps.setBoolean(3, ((Car) vehicle).isPowerSteering());
			ps.setBoolean(4, ((Car) vehicle).getAccessoryKit());
			result = ps.execute();
			System.out
					.println("information with related car successfully inserted in car and vechile table");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (con != null) {
					con.close();
				}
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Inserting Data in Bike table
	 * @param vehicle
	 * @return
	 */
	private boolean insertIntoBike(Vehicle vehicle) {
		Connection con = null;
		PreparedStatement ps = null;
		// ResultSet rs = null;
		boolean result;
		con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Bike (`vehicleId`, `SelfStart`, `HelmetPrice`)"
				+ " VALUES (?, ?, ?);  ";
		try {
			ps = con.prepareStatement(query);
			ps.setDouble(1, vehicle.getVehicleId());
			ps.setBoolean(2, ((Bike) vehicle).isSelfStart());
			ps.setInt(3, ((Bike) vehicle).getHelmetPrice());
			result = ps.execute();
			System.out
					.println("information with related car successfully inserted in bike and vechile table");
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				if (ps != null) {
					ps.close();
				}
				ConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;

	}
}
