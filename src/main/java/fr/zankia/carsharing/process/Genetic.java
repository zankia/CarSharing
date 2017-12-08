package fr.zankia.carsharing.process;

import fr.zankia.carsharing.data.CityState;

/**
 * Genetic algorithm. This algorithm take the most efficient solution within random possibilities.
 * @see <a href="https://en.wikipedia.org/wiki/Genetic_algorithm">Genetic algorithm</a>
 * @since 0.1
 */
public class Genetic implements Algorithm {
    private static String name = "Genetic";


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
