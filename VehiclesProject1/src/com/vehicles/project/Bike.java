package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {
	
	protected Wheel frontWheel;
	protected Wheel backWheel;

	public Bike(String plate, String brand, String color, Owner owner) {
		super(plate, brand, color, owner);
		
		this.frontWheel = frontWheel;
		this.backWheel = backWheel;
		
	}
	
public void addWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		frontWheel = wheels.get(0);
		backWheel = wheels.get(1);

	}


public String toString() {
	return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + 
			", [FrontWheel=" + frontWheel  + " backWheel=" + backWheel + "]";
}

}

