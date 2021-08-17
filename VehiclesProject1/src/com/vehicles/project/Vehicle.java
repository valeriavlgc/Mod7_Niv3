package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
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
		this.owner = owner;
	}
	
   public void addPerson(Person person) {
	   persons.add(person);
	   
   }
   
   //persons que viene tb el owner
   public String getPersons() {
	   String lista = "";

   	for (Person e : persons) {
   		lista += e + "\n";
   	}
  	
   	return lista;
   	
   }

@Override
public String toString() {
	return "Vehicle [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + ", owner="
			+ owner + ", persons=" + persons + "]";
}
  
	 	
}