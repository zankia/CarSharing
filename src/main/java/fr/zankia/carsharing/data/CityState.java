package fr.zankia.carsharing.data;


import java.util.ArrayList;
import java.awt.geom.Point2D;


/**
 * CityState is a set of vehicles and points to travel.
 * @since 0.2
 */
public class CityState {
    /**
     * Collection of the vehicles used by the map.
     */
    private ArrayList<Vehicle> vehicles;
    /**
     * Collection of the points to travel
     */
    private ArrayList<Point2D.Float> waypoints;


    /**
     * Constructs a CityState.
     */
    public CityState() {
        vehicles = new ArrayList<Vehicle>();
        waypoints = new ArrayList<Point2D.Float>();
    }


    /**
     * Adds a point.
     * @param point a point to add
     */
    public void addPoint(Point2D.Float point) {
        waypoints.add(point);
    }


    /**
     * Adds a vehicle.
     * @param vehicle a vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }


    /**
     * Removes a point.
     * @param point the point to remove
     */
    public void removePoint(Point2D.Float point) {
        waypoints.remove(point);
    }


    /**
     * Removes a vehicle.
     * @param vehicle the vehicle to remove
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }
}
