package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Driver;
import com.vehicles.project.Owner;
import com.vehicles.project.Truck;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;
import com.vehicles.project.License;


public class VehicleController {

	private static List<Vehicle> vehicles =new ArrayList<Vehicle>();
	
	public static void newVehicle(Owner owner) throws Exception {
		Scanner sc = new Scanner(System.in);
		UserController usController = new UserController();
		String plate, brand, color, answer, tipo;
		Car car1; Bike bike1; Truck truck1;
		Driver driver = null;
		char type;
     	int i, counterDig = 0, counterLetter = 0;
		boolean end = true, additional = false;
		
		type = (owner.getLicense()).getType();
		
		
		System.out.println("Qué tipo de vehiculo desea crear (coche/moto/camión");
	    tipo = sc.nextLine();
        
	    
	    owner.checkLicense(type, tipo);
	    
		do {
			System.out.println("Por favor, introduzca la matricula");
			plate = sc.nextLine();
			
			
			for (i = 0; i < plate.length(); i++) {
				
				if (Character.isDigit(plate.charAt(i))) {
					counterDig += 1;
				} else if (Character.isLetter(plate.charAt(i))) {
					counterLetter += 1;
				}
			}
			
			
			if (counterDig != 4 || counterLetter < 2) {
				end = false;
				System.out.println("Una matrícula debe llevar 4 letras y un mínimo de 2 dígitos.");
			} else {
				
				end = true;
			}
			  counterDig = 0; counterLetter = 0;
			  
			} while (!end);
		
		
			System.out.println("Introduzca la marca");
			brand = sc.nextLine();
			System.out.println("Introduzca el color");
			color = sc.nextLine();
			
			System.out.println("¿El titular del vehículo es el conductor?");
			answer = sc.nextLine();
			if (answer.equalsIgnoreCase("no")) {
				driver = usController.createDriver();
				type = (driver.getLicense()).getType();
				driver.checkLicense(type, tipo);
				additional = true;
			}	
			
			if (tipo.equalsIgnoreCase("coche")) {
				   car1 = createCar(plate, brand, color, owner); 
				   if (additional) {
					   car1.addPerson(driver);
				   }
			 } else if (tipo.equalsIgnoreCase("camion")) {
			       truck1 = createTruck(plate, brand, color, owner);
			       if (additional) {
					   truck1.addPerson(driver);
				   }
			 } else if (tipo.equalsIgnoreCase("moto")) {
			       bike1 = createBike(plate, brand, color, owner);
			       if (additional) {
					   bike1.addPerson(driver);
				   }
			 }
			
	
			
		}	
	
	public static Car createCar(String plate, String brand, String color, Owner owner) {
		String tipo = "car";
		
		Car car1 = new Car(plate, brand, color, owner);
				
		System.out.println("Información de ruedas delanteras:");
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels = WheelsInformation(tipo);
		
		System.out.println("Información de ruedas traseras:");
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels = WheelsInformation(tipo);
		
		try {
		car1.addWheels(frontWheels, backWheels);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		
		car1.addPerson(owner);
		
		vehicles.add(car1);
		
		return car1;

		
	}
	
	public static Truck createTruck(String plate, String brand, String color, Owner owner) {
        String tipo = "camion";
		
		Truck truck1 = new Truck(plate, brand, color, owner);
				
		System.out.println("Información de ruedas delanteras:");
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels = WheelsInformation(tipo);
		
		System.out.println("Información de ruedas traseras:");
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels = WheelsInformation(tipo);
		
		try {
		truck1.addWheels(frontWheels, backWheels);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		
		
		vehicles.add(truck1);
		
		return truck1;
	}
	
	public static Bike createBike(String plate, String brand, String color, Owner owner) {
		String tipo = "bike";
		
		Bike bike1 = new Bike(plate, brand, color, owner);
		
		System.out.println("Información de rueda delantera:");
		List<Wheel> frontWheel = new ArrayList<Wheel>();
		frontWheel = WheelsInformation(tipo);
		Wheel frontWheel1 = frontWheel.get(0);
		bike1.addFrontWheel(frontWheel1);
		
		System.out.println("Información de rueda trasera:");
		List<Wheel> backWheel = new ArrayList<Wheel>();
		backWheel = WheelsInformation(tipo);
		Wheel backWheel1 = backWheel.get(0);
		bike1.addBackWheel(backWheel1);
		
		vehicles.add(bike1);
		
	    return bike1;
		
	}
	
	public static List<Wheel> WheelsInformation(String tipo) {
		Scanner sc = new Scanner(System.in);
		String brandWheel; double diameter;
		List<Wheel>setWheels = new ArrayList<Wheel>();
			
		do {
			
			System.out.println("Introduzca el diámetro(0.4 - 4)");
			diameter = sc.nextDouble();
			sc.nextLine();
			
		} while(diameter < 0.4 || diameter > 4);
		
			System.out.println("Introduzca la marca");
			brandWheel = sc.nextLine();
		
		Wheel newWheel = new Wheel(brandWheel, diameter);
		
		
		if (tipo.equalsIgnoreCase("bike")) {
			
				setWheels.add(newWheel); 
				
		} else if (tipo.equalsIgnoreCase("car") || tipo.equalsIgnoreCase("camion") ) {
			
		    setWheels.add(newWheel); 
			setWheels.add(newWheel);
		}
		
			return setWheels;
		}	

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
    public void getAllVehicles() {
    int i = 1;	
		for (Vehicle e : vehicles) {
			System.out.println(i + ".-" + e.toString());
			i++;
		}
    }
    
    public List<Vehicle> getVehiclesList(){
    	return vehicles;
    }
	
}
