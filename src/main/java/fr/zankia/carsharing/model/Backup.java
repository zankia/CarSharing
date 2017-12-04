package fr.zankia.carsharing.model;

import fr.zankia.carsharing.data.Map;

public interface Backup {
    public Map load();
    public void save();
}
