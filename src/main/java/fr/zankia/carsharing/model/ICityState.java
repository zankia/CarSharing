package fr.zankia.carsharing.model;

import java.awt.geom.Point2D;
import java.util.List;

public interface ICityState {
    /**
     * Adds a passenger.
     * @param passenger a passenger to add
     */
    void addPoint(IPassenger passenger);

    /**
     * Adds a vehicle.
     * @param vehicle a vehicle to add
     */
    void addVehicle(IVehicle vehicle);

    /**
     * Removes a passenger.
     * @param passenger the passenger to remove
     */
    void removePoint(IPassenger passenger);

    /**
     * Removes a vehicle.
     * @param vehicle the vehicle to remove
     */
    void removeVehicle(IVehicle vehicle);

    /**
     * Returns all the passenger locations.
     * @return the passenger locations
     */
    List<Point2D> getLocations();

    /**
     * Returns all the passenger destinations.
     * @return the passenger destinations
     */
    List<Point2D> getDestinations();

    List<IVehicle> getVehicles();

    List<IPassenger> getWaypoints();

    void clear();

    void setVehicles(List<IVehicle> vehicles);

    void moveVehicles();
}
