package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Vehicle {
	
	//protected List<Wheel> wheels = new ArrayList<Wheel>();


	public Truck(String plate, String brand, String color, Owner owner) {
		super(plate, brand, color, owner);

		//this.wheels = wheels;
	}	
	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels); 
		addTwoWheels(backWheels);
	}
	
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();
	
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);
	
		if (!rightWheel.equals(leftWheel))
			throw new Exception();
	
		this.wheels.add(leftWheel); 
		this.wheels.add(rightWheel);
	}
	
	public void getFrontWheels() {
	   
	  System.out.println(super.wheels.get(0));
	  System.out.println(super.wheels.get(1));
	   
	}	
	
	public void getBackWheels() {
	  System.out.println(super.wheels.get(2));
	  System.out.println(super.wheels.get(3));
	}
	

	public String toString() {
		return "Truck [plate=" + plate + ", brand=" + brand + ", color=" + color +
				", [FrontWheels, R=" + wheels.get(0) + ", L=" + wheels.get(1) +
				"] [BackWheels R=" + wheels.get(2) + ", L=" + wheels.get(3) + "]";
	}
	
	

}

