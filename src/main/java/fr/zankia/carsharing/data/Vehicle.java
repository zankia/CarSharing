package main.java.fr.zankia.carsharing.data;

import java.util.LinkedList;

public class Vehicle {

	private int capacity;
	private CrossingPoint startPoint;
	private LinkedList<CrossingPoint> route;

	public Vehicle(int capacity, float x, float y) {
		this.setCapacity(capacity);
		startPoint = new CrossingPoint(x, y);
		route = new LinkedList<CrossingPoint>();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public LinkedList<CrossingPoint> getRoute() {
		return route;
	}

	public void addCrossingPoint(CrossingPoint point) {
		route.add(point);
	}

	public void removeCrossingPoint(CrossingPoint point) {
		route.remove(point);
	}

	public CrossingPoint getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(CrossingPoint startPoint) {
		this.startPoint = startPoint;
	}

}
