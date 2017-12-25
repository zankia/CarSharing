package fr.zankia.carsharing.model;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


/**
 * CityState is a set of vehicles and points to travel.
 * @since 0.2
 */
public class CityState implements ICityState {
    /**
     * Collection of the vehicles used by the map.
     */
    private List<IVehicle> vehicles;
    /**
     * Collection of the points to travel
     */
    private List<Passenger> waypoints;


    /**
     * Constructs a CityState.
     */
    public CityState() {
        vehicles = new ArrayList<>();
        waypoints = new ArrayList<>();
    }


    @Override
    public void addPoint(Passenger passenger) {
        waypoints.add(passenger);
    }


    @Override
    public void addVehicle(IVehicle vehicle) {
        vehicles.add(vehicle);
    }


    @Override
    public void removePoint(Passenger passenger) {
        waypoints.remove(passenger);
    }


    @Override
    public void removeVehicle(IVehicle vehicle) {
        vehicles.remove(vehicle);
    }


    @Override
    public List<Point2D.Float> getLocations() {
        List<Point2D.Float> list = new ArrayList<>();
        for(Passenger p : waypoints) {
            list.add(p.getLocation());
        }
        return list;
    }


    @Override
    public List<Point2D.Float> getDestinations() {
        List<Point2D.Float> list = new ArrayList<>();
        for(Passenger p : waypoints) {
            list.add(p.getDestination());
        }
        return list;
    }
}
