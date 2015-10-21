package com.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.model.Employee;



public class EmployeeCache {
	private static Map<Integer, Employee> cache = new ConcurrentHashMap<Integer, Employee>();
	private static EmployeeCache employeeCache = new EmployeeCache();
	private EmployeeCache() {
		cache.put(1, new Employee("Akshat Mathur", "akshat.mathur@gmail.com", 1, 22, "25-04-1989"));
		cache.put(2, new Employee("Anuj Sharma", "anuj.sharma@gmail.com", 2, 23, "25-04-1989"));
		cache.put(3, new Employee("Nikhil Singhal", "nikhil.singhal@gmail.com", 3, 24, "25-04-1989"));
	}
	
	/**
	 * @return Instance of Employee Cache
	 */
	public static EmployeeCache getInstance() {
		return employeeCache;
	}

	/**
	 * @param id
	 * @return	Employee
	 */
	public Employee getEmployeeForId(int id) {
		if(!(cache.isEmpty())) {
			return cache.get(id);
		} else {
			return null;
		}
	}
	/**
	 * @return Employee List
	 */
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(cache.values());
	}
	/**
	 * @param employee
	 */
	public void updateEmployee(Employee employee) {
		cache.put(employee.getId(),employee);
	}
	/**
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		cache.put(employee.getId(),employee);
	}

}