package com.vehicles.view;

import java.lang.ModuleLayer.Controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.vehicles.application.UserController;
import com.vehicles.application.VehicleController;
import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Driver;
import com.vehicles.project.License;
import com.vehicles.project.Owner;
import com.vehicles.project.Person;
import com.vehicles.project.Truck;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;

public class Main {

	public static void main(String[] args) throws Exception {
		Date date1 = new Date(); Date date2 = new Date(); Date date3 = new Date(); Date date4 = new Date();
		License license1= new License("234565L", 'a', "Valeria Lavin", "27/02/2025"); License license2 = new License ("23454545L", 'b', "Manuel Jos� Gonz�lez", "21/02/2026"); 
		License license3 = new License("23345L", 'c', "Eduardo G�mez", "27/03/2020"); License license4 = new License("277765L", 'c', "Rosa D�az", "20/03/2035");
		UserController usController = new UserController();
		VehicleController vehicleController = new VehicleController();

		Owner owner1 = new Owner("Valeria", "Lav�n", date1, license1, "si", "no");
		Owner owner2 = new Owner("Manuel Jos�", "Gonz�liez", date2, license2, "si", "si");
		Owner owner3 = new Owner("Eduardo", "G�mez", date3, license3, "no", "no");
		Driver driver1 = new Driver("Rosa", "Di�z", date4, license4);
		usController.addUser(owner1); usController.addUser(owner2); usController.addUser(owner3); usController.addUser(driver1);
		Bike bike1 = new Bike("1234LG", "Renault", "rojo", owner1);
		Car car1 = new Car("1234LG", "Renault", "rojo", owner2);
		Truck truck1 = new Truck("1234LG", "Renault", "rojo", owner3);	
		bike1.addPerson(owner1); car1.addPerson(owner2); truck1.addPerson(owner3); bike1.addPerson(driver1);
		vehicleController.addVehicle(bike1); vehicleController.addVehicle(car1); vehicleController.addVehicle(truck1);
		
		Scanner sc = new Scanner(System.in);
		int option; boolean fin = false;

		do {
			System.out.println("Introduzca una opci�n: 1.- Gestionar veh�culos 2.- Gestionar usuarios 0.- Salir del men�");
			option = sc.nextInt();
		switch (option) {
			case 0 : 
				System.out.println("Adi�s!");
				fin = true;
				break;
			case 1:
				vehiclesMenu();
				break;
			case 2:
				usersMenu();
				break;
		    default:
		    	System.out.println("opci�n no v�lida");
	    }
		
		} while (!fin);
			

   }
	
public static void vehiclesMenu() throws Exception {
Scanner sc = new Scanner(System.in);
int option; boolean fin = false;	
Owner owner; 
VehicleController controller = new VehicleController();
UserController usController = new UserController();


       do {
       	   System.out.println("Introduzca una opci�n: \n 1.- Crear veh�culo \n 2.- Ver todos los veh�culos \n 0.- Volver al men� inicial");
    	   option = sc.nextInt();
		switch (option) {
			case 0 : 
				fin = true;
				break;
			case 1:
				System.out.println("Es necesario crear un propietario para el veh�culo.");
				owner = usController.createOwner();
				controller.newVehicle(owner);
				break;
			case 2:
				controller.getAllVehicles();
				break;
		    default:
		    	System.out.println("opci�n no v�lida");
	    } 
		
        } while (!fin);
	
}	

public static void usersMenu() throws Exception {
Scanner sc = new Scanner(System.in);
int option; boolean fin = false;
Owner owner; Driver driver; String answ;
VehicleController controller = new VehicleController();
UserController usController = new UserController();
String usersList;


       do {
       	   System.out.println("Introduzca una opci�n: \n 1.- Crear titular \n 2.- A�adir conductor a un veh�culo \n 3.- Ver datos de titulares y conductores \n 0.- Volver al men� inicial");
    	   option = sc.nextInt();
		switch (option) {
			case 0 : 
				fin = true;
				break;
			case 1:
				owner = usController.createOwner();
				System.out.println("�Desea asignar un veh�culo al titular?");
				answ = sc.nextLine();
				if(answ.equalsIgnoreCase("si")) {
				 controller.newVehicle(owner);	
				} else {
					System.out.println("Titular sin veh�culo asignado.");
				}
				break;
			case 2:
				driver = usController.createDriver();
				addDriver(driver);
				
				break;
			case 3: 
				usersList = usController.getUsersList();
				System.out.println(usersList);
				break;
		    default:
		    	System.out.println("opci�n no v�lida");
	    } 
		
        } while (!fin);
	
}

public static void addDriver(Driver driver) {
Scanner sc = new Scanner(System.in);
VehicleController controller = new VehicleController();	
List<Vehicle> vehicles =new ArrayList<Vehicle>();
int choice; char license;
	
    controller.getAllVehicles();
	System.out.println("Seleccione el veh�culo al que a�adir el conductor");
	choice = sc.nextInt();
	vehicles = controller.getVehiclesList();
	license = driver.getLicense().getType();
	String tipo = vehicles.get(choice-1).getClass().getName();
	try {
	driver.checkLicense(license, tipo);
	//no ir�a abajo?
	vehicles.get(choice-1).addPerson(driver);
	} catch (Exception e) {
		System.out.println("No se a�adi� al conductor por tener una licencia inadecuada.");
	}
	
}

}
