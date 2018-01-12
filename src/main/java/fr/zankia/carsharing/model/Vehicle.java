package fr.zankia.carsharing.model;


import java.awt.geom.Point2D;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    private LinkedList<Map.Entry<Point2D, Integer>> route;
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
        int i = addLocation(0, passenger.getLocation());
        addLocation(i+1, passenger.getDestination());
    }


    /**
     * Adds a location to the route. The result route is the shortest possible
     * @param from the index to begin search
     * @param locationToAdd the location to add
     */
    private int addLocation(int from, Point2D locationToAdd) {
        int i = -1;
        int capacity = 0;
        double minDistance;
        boolean pickup = from == 0;
        if (pickup) {
            minDistance = location.distance(locationToAdd);
        } else {
            --from;
            minDistance = Double.MAX_VALUE;
        }
        for (int j = from; j < route.size(); ++j) {
            Map.Entry<Point2D, Integer> entry = route.get(j);
            double distance = locationToAdd.distance(entry.getKey());
            if (minDistance >= distance) {
                if (entry.getValue() >= this.getCapacity()) {
                    minDistance = Double.MAX_VALUE;
                    i = route.size()-1;
                    capacity = 0;
                } else {
                    minDistance = distance;
                    i = j;
                    capacity = entry.getValue();
                }
            }
        }
        ++i;
        route.add(i, new AbstractMap.SimpleEntry<>(locationToAdd, capacity));
        for (int j = i; j < route.size(); ++j) {
            this.route.get(j).setValue(route.get(j).getValue() + (pickup ? 1 : -1));
        }
        return i;
    }


    @Override
    public Point2D getNextWaypoint() {
        Map.Entry<Point2D, Integer> entry = route.peekFirst();
        if (entry == null) {
            return null;
        }
        return entry.getKey();
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
        if (getNextWaypoint() == null) {
            return 0;
        }
        double cost = location.distance(getNextWaypoint());
        for (int i = 0; i < route.size() - 1; ++i) {
            cost += route.get(i).getKey().distance(route.get(i+1).getKey());
        }
        return cost;
    }

    @Override
    public ArrayBlockingQueue<IPassenger> getPassengers() {
        return passengers;
    }

    @Override
    public List<Point2D> getRoute() {
        List<Point2D> list = new LinkedList<>();
        for(Map.Entry<Point2D, Integer> entry : this.route) {
            list.add(entry.getKey());
        }
        return list;
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
