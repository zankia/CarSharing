package fr.zankia.carsharing.model;

import java.awt.geom.Point2D;

public interface IPassenger {
    /**
     * Getter of the location.
     * @return the location
     */
    Point2D.Float getLocation();

    /**
     * Setter of the location.
     * @param location the location to set
     */
    void setLocation(Point2D.Float location);

    /**
     * Getter of the destination.
     * @return the destination
     */
    Point2D.Float getDestination();

    /**
     * Setter of the destination.
     * @param destination the destination to set
     */
    void setDestination(Point2D.Float destination);
}
