package br.com.parking;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import br.com.parking.vehicle.Vehicle;
import br.com.parking.vehicle.VehicleType;

public class ParkingLot {

	private List<Vehicle> vehicle = new LinkedList<Vehicle>();
	private double billed;
	private Operator operator;
	private UUID uuid = UUID.randomUUID();
	
	
	public ParkingLot() {
		this.billed = 0;
		this.vehicle = new LinkedList<Vehicle>();
	}


	public List<Vehicle> getVehicle() {
		return vehicle;
	}


	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}


	public double getBilled() {
		return billed;
	}


	public void setBilled(double billed) {
		this.billed = billed;
	}


	public Operator getOperator() {
		return operator;
	}


	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public String showBilled() {
		String totalBilled = String.format("Total invoiced until moment: %s ", this.getBilled());
		return totalBilled;
	}
	
	public void registerVehicleEntry(Vehicle vehicle) {
		vehicle.entryTime = LocalDate.now();
		this.generatesTicket(vehicle);
		this.vehicle.add(vehicle);
	}
	
	public String registerVhicleExit(String plate) {
		Vehicle vehicleExit = null;
		String info = "";
		
		for (Vehicle v : this.vehicle) {
			if (v.getPlate() == plate) {
				v.setDepartureTime(LocalDate.now());
				double timeRemained = Duration.between(v.getEntryTime(), v.getDepartureTime()).toHours();
				double amountToBeCharged = 0;
				if(v.getType() == VehicleType.AUTOMOBILE) {
					amountToBeCharged = Math.ceil(timeRemained) * 2;
				}
				if(v.getType() == VehicleType.MOTORCYCLE) {
					amountToBeCharged = Math.ceil(timeRemained) * 1;
				}
				info = String.format(
						  "Entry time: %s \n"
						+ "Exit time: %s \n"
						+ "Time Remained: %s \n"
						+ "Amount to Pay: %s \n",
						v.getEntryTime(), v.getDepartureTime(), timeRemained, amountToBeCharged);
				vehicleExit = v;
				this.billed = this.billed + amountToBeCharged;
				break;
			}
		}
		if(vehicleExit != null) {
			this.vehicle.remove(vehicleExit);
		} else {
			return "No vehicle found with the given license plate.";
		}
		
		return info;		
	}
	
//	public Vehicle searchVehicle(String idTicket) {
//		var found = 
//	}
	
//	public Vehicle changeDataVehicle(String idTicket) {
//		
//	}
	
	
	
	public String generatesTicket(Vehicle vehicle) {
		vehicle.idTicket = uuid.toString().substring(0, 5);
		String ticket = String.format(
				  "Ticket Parking Lot \n"
				+ "Identifier: %s \n"
				+ "Entry date and time: %s \n"
				+ "Plate Vehicle: %s \n"
				+ "Operator Parking lot: %s \n",
				vehicle.idTicket, LocalDate.now(), vehicle.getPlate(), this.getOperator().getName());
		vehicle.setTicket(ticket);
		return ticket;
	}
}
