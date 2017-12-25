package fr.zankia.carsharing.database;

import fr.zankia.carsharing.model.CityState;

/**
 * The interface for saving model.
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
