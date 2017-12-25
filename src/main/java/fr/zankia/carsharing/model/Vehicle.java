package fr.zankia.carsharing.model;


import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;



/**
 * The Vehicle moves across the city transporting Passengers
 * @since 0.1
 */
public class Vehicle implements IVehicle {
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
    private ArrayBlockingQueue<IPassenger> passengers;


    /**
     * Constructs a Vehicle at the given Point.
     * @param capacity the capacity
     * @param location the initial location
     */
    public Vehicle(int capacity, Point2D.Float location) {
        this.capacity = capacity ;
        this.location = location;
        this.route = new LinkedList<>();
        this.passengers = new ArrayBlockingQueue<>(capacity);
    }


    @Override
    public int getCapacity() {
        return capacity;
    }


    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public Point2D.Float getLocation() {
        return location;
    }


    @Override
    public void setLocation(Point2D.Float location) {
        this.location = location;
        route.remove(location);
    }


    @Override
    public void addRoute(IPassenger passenger) {
        addLocation(passenger.getLocation());
        addLocation(passenger.getDestination());
    }


    /**
     * Adds a location to the route.
     * @param locationToAdd the location to add
     */
    private void addLocation(Point2D.Float locationToAdd) {
        int i = -1;
        double minDistance = location.distance(locationToAdd);
        for (Point2D.Float point : route) {
            double distance = locationToAdd.distance(point);
            if (minDistance > distance) {
                minDistance = distance;
                i = route.indexOf(point);
            }
        }
        route.add(i + 1, locationToAdd);
    }


    @Override
    public Point2D.Float getNextWaypoint() {
        return route.peekFirst();
    }


    @Override
    public boolean addPassenger(IPassenger passenger) throws IllegalStateException {
        if (!isSameLocation(passenger)) {
            return false;
        }
        passengers.add(passenger);
        return true;
    }


    @Override
    public boolean removePassenger(IPassenger passenger) {
        if (!isArrived(passenger) || !passengers.contains(passenger)) {
            return false;
        }
        passengers.remove(passenger);
        return true;
    }


    @Override
    public void clear() {
        passengers.clear();
        route.clear();
    }


    @Override
    public double getCost() {
        double cost = location.distance(getNextWaypoint());
        for (int i = 0; i < route.size() - 1; ++i) {
            cost += route.get(i).distance(route.get(i+1));
        }
        return cost;
    }


    /**
     * Checks if the given Passenger is in the same location
     * @param passenger the Passenger to compare
     * @return wether the Passenger is in the same Location or not
     **/
    private boolean isSameLocation(IPassenger passenger) {
        return passenger.getLocation().equals(location);
    }


    /**
     * Checks if the vehicle in the destination of the given passenger
     * @param passenger the Passenger to compare
     * @return wether the vehicle in in the destination or not
     **/
    private boolean isArrived(IPassenger passenger) {
        if(passenger.getDestination() == null) {
            return false;
        }
        return passenger.getDestination().equals(location);
    }
}
