package fr.zankia.carsharing.process;

import fr.zankia.carsharing.model.CityState;

/**
 * The interface for solving the problem.
 * @since 0.1
 */
public interface Algorithm {
    /**
     * Executes the algorithm and gives the new <code>CityState</code> after one step.
     * During a step, elements can only by only 1 unit.
     * @return a <code>CityState</code> filled with a layout
     */
    public CityState step();
    /**
     * Executes the algorithm for the whole problem in one time.
     */
    public void solve();
}
