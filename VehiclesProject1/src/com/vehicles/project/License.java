package com.vehicles.project;

import java.util.Date;

public class License {

	protected String id;
	protected char type;
	protected String fullName;
	protected String expiringDate;
	
	public License(String id, char tipo, String fullName, String expiringDate) {
		this.id           = id;
		this.type         = tipo;
		this.fullName     = fullName;
		this.expiringDate = expiringDate;
		
	}

	public char getType() {
		
		return type;
	}

	@Override
	public String toString() {
		return "\n" + "license= [id=" + id + ", type=" + type + ", fullName=" + fullName + ", expiringDate=" + expiringDate
				+ "]";
	}
	
	
	
}