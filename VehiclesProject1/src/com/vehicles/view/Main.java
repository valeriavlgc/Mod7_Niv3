package com.vehicles.view;
//ARREGLAR FORMATO HORA
import java.lang.ModuleLayer.Controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vehicles.application.UserController;
import com.vehicles.application.VehicleController;
import com.vehicles.project.Car;
import com.vehicles.project.Driver;
import com.vehicles.project.Owner;
import com.vehicles.project.Person;
import com.vehicles.project.Vehicle;
import com.vehicles.project.Wheel;


public class Main {

	public static void main(String[] args) throws Exception {
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
Owner owner; Driver driver;
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
				//dar opci�n de a�adir el veh�culo al conductor? SI NO PONER SIN VEHICULO ASIGNADO EN EL TOSTRING
				owner = usController.createOwner();
				break;
			case 2:
				//pasar a otra funcion aparte?
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
