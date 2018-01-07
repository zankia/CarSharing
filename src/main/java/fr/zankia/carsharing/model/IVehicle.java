package fr.zankia.carsharing.model;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public interface IVehicle {
    /**
     * Getter of the capacity.
     * @return the capacity of the vehicle
     */
    int getCapacity();

    /**
     * Setter of the capacity.
     * @param capacity the capacity to set
     */
    void setCapacity(int capacity);

    /**
     * Getter of the location.
     * @return the current location of the Vehicle
     */
    Point2D getLocation();

    /**
     * Setter of the location.
     * @param location the location to set
     */
    void setLocation(Point2D location);

    /**
     * Adds a passenger to the route.
     * @param passenger the passenger to add
     */
    void addRoute(IPassenger passenger);

    /**
     * Returns the next location in the route.
     * @return the next location in the route
     */
    Point2D getNextWaypoint();

    /**
     * Adds a Passenger in the same location.
     * @param passenger the Passenger to add
     * @return wether the Passenger has been added or not
     */
    boolean addPassenger(IPassenger passenger) throws IllegalStateException;

    /**
     * Removes a Passenger.
     * @param passenger the Passenger to remove
     * @return wether the Passenger has been removed or not
     */
    boolean removePassenger(IPassenger passenger);

    /**
     * Empty the passenger informations.
     **/
    void clear();


    /**
     * Returns the total movement cost. It represents the distance to travel to take all passengers
     * and drop them in their destinations.
     * @return the total cost
     */
    double getCost();

    ArrayBlockingQueue<IPassenger> getPassengers();

    List<Point2D> getRoute();
}
