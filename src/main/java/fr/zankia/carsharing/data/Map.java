package fr.zankia.carsharing.data;


import java.util.ArrayList;


/*
 * Map is a set of vehicles and CrossingPoint.
 * @since 0.1
 */
public class Map {

	
	//Collection of the vehicles used by the map.
	private ArrayList<Vehicle> vehicles;
	
	
	//Collection of the CrossingPoints used by the map.
	private ArrayList<CrossingPoint> elements;

	
	/*
	 * Constructor of a Map.
	 */
	public Map() {
		vehicles = new ArrayList<Vehicle>();
		elements = new ArrayList<CrossingPoint>();
	}
	

	/*
	 * Add a CrossingPoint on the Map.
	 * @param elem a CrossingPoint to add
	 */
	public void addElement(CrossingPoint elem) {
		elements.add(elem);
	}

	
	/*
	 * Add a vehicle on the Map.
	 * @param vehic a vehicle to add 
	 */
	public void addVehicle(Vehicle vehic) {
		vehicles.add(vehic);
	}

	
	/*
	 * Remove a CrossingPoint of the Map.
	 * @param elem the CrossingPoint to remove
	 */
	public void removeElement(CrossingPoint elem) {
		elements.remove(elem);
	}

	
	/*
	 * Remove a vehicle. 
	 * @param vehic the vehicle to remove
	 */
	public void removeVehicle(Vehicle vehic) {
		vehicles.remove(vehic);
	}
	
	
}
