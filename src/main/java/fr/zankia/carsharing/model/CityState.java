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
    private List<IPassenger> waypoints;


    /**
     * Constructs a CityState.
     */
    public CityState() {
        vehicles = new ArrayList<>();
        waypoints = new ArrayList<>();
    }


    @Override
    public void addPoint(IPassenger passenger) {
        waypoints.add(passenger);
    }


    @Override
    public void addVehicle(IVehicle vehicle) {
        vehicles.add(vehicle);
    }


    @Override
    public void removePoint(IPassenger passenger) {
        waypoints.remove(passenger);
    }


    @Override
    public void removeVehicle(IVehicle vehicle) {
        vehicles.remove(vehicle);
    }


    @Override
    public List<Point2D> getLocations() {
        List<Point2D> list = new ArrayList<>();
        for(IPassenger p : waypoints) {
            list.add(p.getLocation());
        }
        return list;
    }


    @Override
    public List<Point2D> getDestinations() {
        List<Point2D> list = new ArrayList<>();
        for(IPassenger p : waypoints) {
            if (p.getDestination() != null) {
                list.add(p.getDestination());
            }
        }
        return list;
    }


    @Override
    public List<IVehicle> getVehicles() {
        return vehicles;
    }


    @Override
    public List<IPassenger> getWaypoints() {
        return waypoints;
    }


    @Override
    public void clear() {
        vehicles.clear();
        waypoints.clear();
    }

    @Override
    public void setVehicles(List<IVehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
