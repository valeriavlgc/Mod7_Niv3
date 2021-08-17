package com.vehicles.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.vehicles.project.Driver;
import com.vehicles.project.License;
import com.vehicles.project.Owner;
import com.vehicles.project.Person;


public class UserController {
	
	private static List<Person> users =new ArrayList<Person>();
	
	public static Owner createOwner() throws ParseException {
	Scanner sc = new Scanner(System.in);
	String name, surname, garage, insurance, birthdate;
	License license;
	
		System.out.println("Introduzca nombre");
		name = sc.nextLine();
		System.out.println("Introduzca apellido");
		surname = sc.nextLine();
		System.out.println("Introduzca fecha de nacimiento (dd/MM/yyyy)");
		birthdate = sc.nextLine();
		license = createLicense();
		System.out.println("¿Tiene garaje?");
		garage = sc.nextLine();
		System.out.println("¿Tiene seguro?");
		insurance = sc.nextLine();
		
		Owner owner = new Owner(name, surname, birthdate, license, garage, insurance);
		users.add(owner);
		
		return owner;
	}
 	
	public static Driver createDriver() throws ParseException {
	Scanner sc = new Scanner(System.in);
	String name, surname, garage, insurance, birthdate;
	License license;
	
	        System.out.println("****Datos del conductor****");
			System.out.println("Introduzca nombre");
			name = sc.nextLine();
			System.out.println("Introduzca apellido");
			surname = sc.nextLine();
			System.out.println("Introduzca fecha de nacimiento (dd/MM/yyyy)");
			birthdate = sc.nextLine();
			license = createLicense();
		
			
		Driver driver = new Driver(name, surname, birthdate, license);	
		users.add(driver);
		
		return driver;
		
	}
	
    public static License createLicense() throws ParseException {
    Scanner sc = new Scanner(System.in);
    String id, fullName, expiringDate;
    char type;
        
    System.out.println("***Datos de Licencia***");
    System.out.println("Introduzca su ID");
    id = sc.nextLine();
    System.out.println("Introduzca el tipo de licencia que posee (a/b/c)");
    type = sc.next().charAt(0);
    sc.nextLine();
    System.out.println("Introduzca su nombre completo");
    fullName = sc.nextLine();
    System.out.println("Introduzca la fecha de caducidad del ID (dd/MM/yyyy)");
    expiringDate = sc.nextLine();
    
    
    License license = new License (id, type, fullName, expiringDate);	
    
    	return license;
    }
  
    public static String getUsersList(){
    	String lista = "";
    	
    	lista += "***Propietarios***"+ "\n";
    	for (Person e : users) {
    		if (e instanceof Owner)
    		lista += e + "\n";
    	}
    	
    	lista += "***Conductores***" + "\n";
    	for (Person e : users) {
    		if (e instanceof Driver) {
    			lista += e + "\n";
    		}
    	}
    	
    	return lista;
    	
    }
 
    public static void addUser(Person person) {
    	users.add(person);
    }
}
