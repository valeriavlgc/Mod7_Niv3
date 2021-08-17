package com.vehicles.project;

import java.util.Date;

public class Owner extends Person {
	
	protected String garage;
	protected String insurance;
	
	
	public Owner(String name, String surname, String birthdate, License license, String garage, String insurance) {
		super(name, surname, birthdate, license);
		this.garage    = garage; 
		this.insurance = insurance;
		
	}
	

	public String toString() {
		return "Owner [name=" + name + ", surname=" + surname + ", birthdate=" + birthdate +  ", garage=" + garage + ", insurance=" + insurance + "." + license
				+  "]";
	}


}
