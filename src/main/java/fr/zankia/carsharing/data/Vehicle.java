package fr.zankia.carsharing.data;


import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.geom.Point2D;


/**
 * The Vehicle moves across the city transporting Passengers
 * @since 0.1
 */
public class Vehicle {
    /**
     * Maximum Passengers amount.
     **/
    private int capacity;
    /**
     * Location of the vehicle in the city.
     */
    private Point2D.Float location;
    /**
     * Current route of the Vehicle. In this Collection, there are the points
     * where the Vehicle has to go. It is ordered for having the shortest route.
     */
    private LinkedList<Point2D.Float> route;
    /**
     * The list of the Passenger in the Vehicle
     */
    private ArrayList<Passenger> passengers;


    /**
     * Constructs a Vehicle at the given Point.
     * @param capacity the capacity
     * @param location the initial location
     */
    public Vehicle(int capacity, Point2D.Float location) {
        this.capacity = capacity ;
        this.location = location;
        this.route = new LinkedList<Point2D.Float>();
        this.passengers = new ArrayList<Passenger>();
    }


    /**
     * Getter of the capacity.
     * @return the capacity of the vehicle
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Setter of the capacity.
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    /**
     * Getter of the location.
     * @return the current location of the Vehicle
     */
    public Point2D.Float getLocation() {
        return location;
    }


    /**
     * Setter of the location.
     * @param location the location to set
     */
    public void setLocation(Point2D.Float location) {
        this.location = location;
    }


    /**
     * Adds a passenger to the route
     * @param passenger the passenger to add
     */
    public void addRoute(Passenger passenger) {
        route.add(passenger.getLocation());
    }


    /**
     * Adds a Passenger
     * @param passenger the Passenger to add
     * @return wether the Passenger has been added or not
     */
    public boolean addPassenger(Passenger passenger) {
        if(passengers.size() > capacity) {
            return false;
        }
        passengers.add(passenger);
        return true;
    }


    /**
     * Removes a Passenger
     * @param passenger the Passenger to remove
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
}
