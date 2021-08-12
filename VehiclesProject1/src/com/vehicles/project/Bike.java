package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color, Owner owner) {
		super(plate, brand, color, owner);
	}
	
public void addWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel frontWheel = wheels.get(0);
		Wheel backWheel = wheels.get(1);

	}

public void addFrontWheel(Wheel frontWheel) {
	this.wheels.add(frontWheel);
}

public void addBackWheel(Wheel backWheel) {
	this.wheels.add(backWheel);
}

@Override
public String toString() {
	return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + 
			", frontWheel=" + wheels.get(0)  + " backWheel=" + wheels.get(1) + "]";
}


}

