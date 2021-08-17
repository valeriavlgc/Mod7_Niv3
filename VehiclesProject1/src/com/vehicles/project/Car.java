package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {
	
		
	public Car(String plate, String brand, String color, Owner owner) {
		super(plate, brand, color, owner);
		
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
	
   
	@Override
	public String toString() {
		return "Car [plate=" + plate + ", brand=" + brand + ", color=" + color +
				", [FrontWheels, R=" + wheels.get(0) + ", L=" + wheels.get(1) +
				"] [BackWheels R=" + wheels.get(2) + ", L=" + wheels.get(3) + "]";
	}

	
	
}

