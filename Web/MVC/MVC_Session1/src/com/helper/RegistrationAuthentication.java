package com.helper;

public class RegistrationAuthentication {

	/**
	 * @param Id
	 * @return Boolean
	 */
	public static boolean check(int Id) {
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if (employeeCache.getEmployeeForId(Id) == null) {
			return true;
		} else {
			return false;
		}
	}
}
