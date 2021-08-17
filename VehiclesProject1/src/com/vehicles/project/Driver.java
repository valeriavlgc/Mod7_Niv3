package com.vehicles.project;

import java.util.Date;

public class Driver extends Person {
	
	public Driver() {}
	public Driver(String name, String surname, String birthdate, License license) {
		super(name, surname, birthdate, license);
	}
		
	
	public String toString() {
		return "Driver [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate + ", license=" + license
				+ "]";
	}


	
}

