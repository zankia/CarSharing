package fr.zankia.carsharing.model;

import java.awt.geom.Point2D;

/**
 * A passenger is the customer, the person want be take by a car.
 * @since 0.1
 */
public class Passenger implements IPassenger {
    /**
     * The current location of the Passenger
     **/
    private Point2D.Float location;
    /**
     * The destination of the Passenger.
     */
    private Point2D.Float destination;


    @Override
    public Point2D.Float getLocation() {
        return location;
    }


    @Override
    public void setLocation(Point2D.Float location) {
        this.location = location;
    }


    @Override
    public Point2D.Float getDestination() {
        return destination;
    }


    @Override
    public void setDestination(Point2D.Float destination) {
        this.destination = destination;
    }


    /**
     * Constructs a Passenger with a destination.
     * @param location the initial location
     * @param destination the destination
     */
    public Passenger(Point2D.Float location, Point2D.Float destination) {
        this.location = location;
        this.destination = destination;
    }


    /**
     * Constructs a Passenger at the given Point.
     * @param location the initial location
     */
    public Passenger(Point2D.Float location) {
        this.location = location;
        this.destination = null;
    }
}
