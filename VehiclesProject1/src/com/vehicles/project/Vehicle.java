package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected Owner owner;
	protected List<Person> persons = new ArrayList<Person>(); 

	public Vehicle(String plate, String brand, String color, Owner owner) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
   public void addPerson(Person person) {
	   persons.add(person);
	   
   }
	 	
}