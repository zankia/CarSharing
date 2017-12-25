package fr.zankia.carsharing.process;

import fr.zankia.carsharing.model.CityState;

/**
 * Simulated annealing algorithm.
 * @see <a href="https://en.wikipedia.org/wiki/Simulated_annealing">Simulated annealing</a>
 * @since 0.1
 */
public class SimulatedAnnealing implements Algorithm {
    private static String name = "Simulated annealing";


    @Override
    public String toString() {
        return name + " algorithm";
    }


    @Override
    public CityState step() {
        //TODO
        return null;
    }


    @Override
    public void solve() {
        //TODO
    }
}
