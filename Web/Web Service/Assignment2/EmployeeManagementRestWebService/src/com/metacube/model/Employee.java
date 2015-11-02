package com.metacube.model;

import java.util.Date;

import lombok.Data;
/**
 * @author Akshat
 *
 */
@Data
public class Employee {
	private int id;
	private String name;
	private String email;
	private Date dateOfBirth;
	private String Address;
}
