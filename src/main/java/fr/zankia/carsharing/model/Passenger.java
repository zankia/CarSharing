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
    private Point2D location;
    /**
     * The destination of the Passenger.
     */
    private Point2D destination;
    private boolean inRoute;


    @Override
    public Point2D getLocation() {
        return location;
    }


    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }


    @Override
    public Point2D getDestination() {
        return destination;
    }


    @Override
    public void setDestination(Point2D destination) {
        this.destination = destination;
    }

    @Override
    public boolean isInRoute() {
        return this.inRoute;
    }

    @Override
    public void setInRoute(boolean b) {
        this.inRoute = b;
    }


    /**
     * Constructs a Passenger with a destination.
     * @param location the initial location
     * @param destination the destination
     */
    public Passenger(Point2D location, Point2D destination) {
        this.location = location;
        this.destination = destination;
    }


    /**
     * Constructs a Passenger at the given Point.
     * @param location the initial location
     */
    public Passenger(Point2D location) {
        this.location = location;
        this.destination = null;
    }
}
