package fr.zankia.carsharing.model;

import fr.zankia.carsharing.data.CityState;

/**
 * The interface for saving data.
 * @since 0.1
 */
public interface Backup {
    /**
     * Returns a <code>CityState</code> filled with a layout.
     * @return a <code>CityState</code> filled with a layout
     */
    public CityState load();
    /**
     * Saves the current layout
     */
    public void save();
}
