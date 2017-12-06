package fr.zankia.carsharing.data;


import java.util.LinkedList;


/*
 * This class represents the vehicles used by a Map.
 * @since 0.1
 */
public class Vehicle {

	
	// Number of passengers available in the car.
	private int capacity;
	
	
	// Initial position of the vehicle on the Map.
	private CrossingPoint startPoint;
	
	
	// Orderly collection of the CrossingPoint by which the car must pass
	private LinkedList<CrossingPoint> route;

	
	/*
	 * Constructor of a Vehicle.
	 * @param capacity a integer will represent the capacity of the vehicle
	 * @param x a float that will be coordX to the start point
	 * @param y a float that will be coordY to the start point
	 */
	public Vehicle(int capacity, float x, float y) {
		this.capacity = capacity ;
		this.startPoint = new CrossingPoint(x, y);
		this.route = new LinkedList<CrossingPoint>();
	}

	
	/*
	 * Getter of the capacity.
	 * @return a integer that represents capacity of the vehicle
	 */
	public int getCapacity() {
		return capacity;
	}

	
	/*
	 * Setter of the capacity.
	 * @param capacity a integer that will be the capacity of the vehicle
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	/*
	 * Getter of the route. 
	 * @return a LinkedList that is the route of the vehicle
	 */
	public LinkedList<CrossingPoint> getRoute() {
		return route;
	}

	
	/*
	 * Add a CrossingPoint to the route.
	 * @param point the CrossingPoint to add
	 */
	public void addCrossingPoint(CrossingPoint point) {
		route.add(point);
	}

	
	/*
	 * Remove a CrossingPoint of the route.
	 * @param point the CrossingPoint to remove
	 */
	public void removeCrossingPoint(CrossingPoint point) {
		route.remove(point);
	}

	
	/*
	 * Getter of the start Point.
	 * @return the startPoint of the vehicle
	 */
	public CrossingPoint getStartPoint() {
		return startPoint;
	}

	
	/*
	 * Setter of the start point.
	 * @param startPoint a CrossingPoint will be the start point of the vehicle
	 */
	public void setStartPoint(CrossingPoint startPoint) {
		this.startPoint = startPoint;
	}

	
}
