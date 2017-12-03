package main.java.fr.zankia.carsharing.data;

import java.util.ArrayList;

public class Map {

	private ArrayList<Vehicle> vehicles;
	private ArrayList<CrossingPoint> elements;

	public Map() {
		vehicles = new ArrayList<Vehicle>();
		elements = new ArrayList<CrossingPoint>();
	}

	public void addElement(CrossingPoint elem) {
		elements.add(elem);
	}

	public void addVehicle(Vehicle vehic) {
		vehicles.add(vehic);
	}

	public void removeElement(CrossingPoint elem) {
		elements.remove(elem);
	}

	public void removeVehicle(Vehicle vehic) {
		vehicles.remove(vehic);
	}
}
