package fr.zankia.carsharing.process;

import fr.zankia.carsharing.data.Map;

/**
 * The interface for solving the problem.
 * @since 0.1
 */
public interface Algorithm {
    /**
     * Returns the name of the <code>Algorithm</code>.
     * @return the name of the <code>Algorithm</code>
     */
    public String getName();
    /**
     * Executes the algorithm and gives the new <code>Map</code> after one step.
     * During a step, elements can only by only 1 unit.
     * @return a <code>Map</code> filled with a layout
     * @see fr.zankia.carsharing.Vehicle
     */
    public Map step();
    /**
     * Executes the algorithm for the whole problem in one time.
     */
    public void solve();
}
