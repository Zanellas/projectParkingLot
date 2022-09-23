package br.com.parking.vehicle;

import java.time.LocalDate;

import br.com.parking.exception.VehicleException;

public class Vehicle {

	private String plate;
	private String proprietary;
	private VehicleType type;
	
	private String ticket;
	public String idTicket;
	
	public String color;
	public Double width;
	public Double currentSpeed;
	public String model;

	public LocalDate entryTime;
	public LocalDate departureTime;

	public Vehicle() {

	}

	public Vehicle(String proprietary) {
		this.testProprietary(proprietary);
		this.proprietary = proprietary;
	}

	public void accelerateCar(int timeSeg) {
		this.currentSpeed += (timeSeg * 10);
	}

	public void breakCar(int timeSeg) {
		this.currentSpeed -= (timeSeg * 15);
	}

	public void changeData(Vehicle alteredVehicle) {
		this.proprietary = alteredVehicle.proprietary;
		this.model = alteredVehicle.model;
		this.width = alteredVehicle.width;
		this.color = alteredVehicle.color;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		if (plate.length() != 8) {
			throw new VehicleException("The plate must have 8 characters!");
		}
		for (int i = 0; i < 3; i++) {
			if (Character.isDigit(plate.charAt(i))) {
				throw new VehicleException("The first 3 characters must be letters!");
			}
		}
		if (plate.charAt(3) != '-') {
			throw new VehicleException("The 4th character must be a hyphen!");
		}
		this.plate = plate;
	}

	public String getProprietary() {
		return proprietary;
	}

	public void setProprietary(String proprietary) {
		this.testProprietary(proprietary);
		this.proprietary = proprietary;
	}

	public void testProprietary(String proprietary) {
		if (proprietary.length() < 3) {
			throw new VehicleException("Invalid proprietary name!");
		}
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getWidth() {
		return width;
	}

	public Double getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(Double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public LocalDate getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDate entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Vehicle data sheet:\n" + 
				"Vehicle type: %s \n" + 
				"Proprietary: %s \n" + 
				"Model: %s \n" + 
				"Color: %s \n" + 
				"Plate: %s \n", 
				this.type.toString(), this.proprietary, this.model, this.color, this.plate);
	}

}
