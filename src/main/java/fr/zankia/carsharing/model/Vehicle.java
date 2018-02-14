package fr.zankia.carsharing.model;


import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;
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
    private Point2D location;
    /**
     * Current route of the Vehicle. In this Collection, there are the points
     * where the Vehicle has to go. It is ordered for having the shortest route.
     */
    private LinkedList<Point2D> route;
    /**
     * The list of the Passenger in the Vehicle
     */
    private ArrayBlockingQueue<IPassenger> passengers;


    /**
     * Constructs a Vehicle at the given Point.
     * @param capacity the capacity
     * @param location the initial location
     */
    public Vehicle(int capacity, Point2D location) {
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
    public Point2D getLocation() {
        return location;
    }


    @Override
    public void setLocation(Point2D location) {
        this.location = location;
        route.remove(location);
    }


    @Override
    public void addRoute(IPassenger passenger) {
        int i = 0;
        if (passenger.getLocation() != null) {
            i = addLocation(0, passenger.getLocation());
        }
        addLocation(i, passenger.getDestination());
    }


    /**
     * Adds a location to the route.
     * @param from the index to begin search
     * @param locationToAdd the location to add
     */
    private int addLocation(int from, Point2D locationToAdd) {
        int i = -1;
        double minDistance;
        if (from == 0) {
            minDistance = location.distance(locationToAdd);
        } else {
            minDistance = Double.MAX_VALUE;
        }
        for (int j = from; j < route.size(); ++j) {
            double distance = locationToAdd.distance(route.get(j));
            if (minDistance > distance) {
                minDistance = distance;
                i = j;
            }
        }
        ++i;
        route.add(i, locationToAdd);
        return i;
    }


    @Override
    public Point2D getNextWaypoint() {
        return route.peekFirst();
    }


    @Override
    public boolean addPassenger(IPassenger passenger) throws IllegalStateException {
        if (!isSameLocation(passenger)) {
            return false;
        }
        passengers.add(passenger);
        if (passenger.getLocation().equals(getNextWaypoint())) {
            route.removeFirst();
        }
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
        clearRoute();
    }


    @Override
    public double getCost() {
        if (getNextWaypoint() == null) {
            return 0;
        }
        double cost = location.distance(getNextWaypoint());
        for (int i = 0; i < route.size() - 1; ++i) {
            cost += route.get(i).distance(route.get(i+1));
        }
        return cost;
    }

    @Override
    public ArrayBlockingQueue<IPassenger> getPassengers() {
        return passengers;
    }

    @Override
    public List<Point2D> getRoute() {
        return this.route;
    }

    @Override
    public int move() {
        Point2D nextWaypoint = getNextWaypoint();
        if (location.equals(nextWaypoint)) {
            return 1;
        }
        if (location.getX() != nextWaypoint.getX()) {
            location.setLocation(location.getX() + (location.getX() < nextWaypoint.getX() ? 1 : -1), location.getY());
        } else if (location.getY() != nextWaypoint.getY()) {
            location.setLocation(location.getX(), location.getY() + (location.getY() < nextWaypoint.getY() ? 1 : -1));
        }
        return 0;
    }

    @Override
    public void clearRoute() {
        this.route.clear();
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
