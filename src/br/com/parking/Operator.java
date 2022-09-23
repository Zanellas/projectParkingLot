package br.com.parking;

import java.util.UUID;

public class Operator {

	private String registration;
	private String name;
	private UUID uuid = UUID.randomUUID();
		
	public Operator(String name) {
		this.name = name;
		this.registration = uuid.toString().substring(0, 8);
	}
	
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Operator: %s \n"
				+ "Registration: %s", name, registration);
	}
}
