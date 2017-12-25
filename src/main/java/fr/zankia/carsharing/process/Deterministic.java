package fr.zankia.carsharing.process;

import fr.zankia.carsharing.model.CityState;

/**
 * Deterministic algorithm. This algorithm explores all the solution and give the most efficient.
 * It could take a lot of time if there are a lot of model to process.
 * @see <a href="https://en.wikipedia.org/wiki/Deterministic_algorithm">Deterministic algorithm</a>
 * @since 0.1
 */
public class Deterministic implements Algorithm {
    private static String name = "Deterministic";


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
