package fr.zankia.carsharing.process;

import fr.zankia.carsharing.data.Map;

public interface Algorithm {
    public String getName();
    public Map step();
    public void solve();
}
