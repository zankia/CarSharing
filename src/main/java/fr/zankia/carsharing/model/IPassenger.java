package fr.zankia.carsharing.model;

import java.awt.geom.Point2D;

public interface IPassenger {
    /**
     * Getter of the location.
     * @return the location
     */
    Point2D getLocation();

    /**
     * Setter of the location.
     * @param location the location to set
     */
    void setLocation(Point2D location);

    /**
     * Getter of the destination.
     * @return the destination
     */
    Point2D getDestination();

    /**
     * Setter of the destination.
     * @param destination the destination to set
     */
    void setDestination(Point2D destination);

    boolean isInRoute();

    void setInRoute(boolean b);
}
