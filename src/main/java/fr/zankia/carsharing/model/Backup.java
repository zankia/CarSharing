package fr.zankia.carsharing.model;

import fr.zankia.carsharing.data.Map;

/**
 * The interface for saving data.
 * @since 0.1
 */
public interface Backup {
    /**
     * Returns a <code>Map</code> filled with a layout.
     * @return a <code>Map</code> filled with a layout
     */
    public Map load();
    /**
     * Saves the current layout
     */
    public void save();
}
