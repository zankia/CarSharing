package fr.zankia.carsharing.process;

import com.google.common.math.DoubleMath;
import fr.zankia.carsharing.Controller;
import fr.zankia.carsharing.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Deterministic algorithm. This algorithm explores all the solution and give the most efficient.
 * It could take a lot of time if there are a lot of model to process.
 * @see <a href="https://en.wikipedia.org/wiki/Deterministic_algorithm">Deterministic algorithm</a>
 * @since 0.1
 */
public class Deterministic implements Algorithm {
    private static String name = "Deterministic";
    /**
     * The logger of this class
     */
    private static final Logger log = Logger.getLogger(Controller.class.getName());


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
        ICityState state = Controller.getInstance().getCityState();
        List<IVehicle> vehicles = state.getVehicles();
        List<IPassenger> passengers = state.getWaypoints();
        List<IVehicle> bestSolution = null;

        double minimumCost = Double.MAX_VALUE;
        for (int j = 0; j < DoubleMath.factorial(vehicles.size()); ++j) {
            int currentVehicle = 0;
            List<IVehicle> currentSolution = new ArrayList<>(vehicles);

            /*
            for (IVehicle vehicle : currentSolution) {
                vehicle.clear();
            }
            for (IPassenger passenger : passengers) {
                passenger.setInRoute(false);
            }
            */

            for (int i = 0; i < passengers.size(); ++i) {
                if (!passengers.get(i).isInRoute()) {
                    try {
                        currentSolution.get(currentVehicle).addRoute(passengers.get(i));
                    } catch (IllegalStateException e) {
                        ++currentVehicle;
                        --i;
                    }
                }
            }
            double totalCost = 0;
            for (IVehicle vehicle : currentSolution) {
                totalCost += vehicle.getCost();
            }
            if (minimumCost > totalCost) {
                minimumCost = totalCost;
                bestSolution = currentSolution;
            }

            swap(vehicles, j % vehicles.size(), (j+1) % vehicles.size());
        }

        state.setVehicles(bestSolution);
    }

    private void swap(List<IVehicle> vehicles, int i, int j) {
        IVehicle v = vehicles.get(i);
        vehicles.set(i, vehicles.get(j));
        vehicles.set(j, v);
    }
}
