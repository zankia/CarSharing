import fr.zankia.carsharing.Controller;
import fr.zankia.carsharing.model.*;
import fr.zankia.carsharing.process.Deterministic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


class DeterministicTest {
    private ICityState state;
    private Point2D.Float origin, destination, farAway;
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = Controller.getInstance();
        controller.setAlgorithm(new Deterministic());
        state = controller.getCityState();
        controller.resetCity();
        origin = new Point2D.Float(0, 0);
        destination = new Point2D.Float(1, 1);
        farAway = new Point2D.Float(10, 10);
    }


    private ICityState setupOneVehicleForOnePassenger(int amount) {
        ICityState newCityState = new CityState();
        for (int i = 0; i < amount; ++i) {
            IPassenger passenger = new Passenger(origin, destination);
            state.addVehicle(new Vehicle(1, origin));
            state.addPoint(passenger);
            IVehicle newVehicle1 = new Vehicle(1, origin);
            newVehicle1.addRoute(passenger);
            newCityState.addVehicle(newVehicle1);
        }
        return newCityState;
    }


    @Test
    void testSolutionOneVehicleOnePassenger() {
        ICityState newCityState = setupOneVehicleForOnePassenger(1);
        List<IVehicle> newCityStateVehicles = newCityState.getVehicles();
        List<IVehicle> solutionVehicles = controller.getSolution().getVehicles();
        for (int i = 0; i < state.getVehicles().size(); ++i) {
            assertIterableEquals(
                    newCityStateVehicles.get(i).getRoute(),
                    solutionVehicles.get(i).getRoute()
            );
        }
    }


    @Test
    void testSolutionOneVehicleTwoPassengers() {
        IPassenger passenger1 = new Passenger(origin, destination);
        IPassenger passenger2 = new Passenger(origin, destination);
        state.addVehicle(new Vehicle(2, origin));
        state.addPoint(passenger1);
        state.addPoint(passenger2);
        ICityState newCityState = new CityState();
        IVehicle newVehicle = new Vehicle(2, origin);
        newVehicle.addRoute(passenger1);
        newVehicle.addRoute(passenger2);
        newCityState.addVehicle(newVehicle);
        List<IVehicle> newCityStateVehicles = newCityState.getVehicles();
        List<IVehicle> solutionVehicles = controller.getSolution().getVehicles();
        for (int i = 0; i < state.getVehicles().size(); ++i) {
            assertIterableEquals(
                    newCityStateVehicles.get(i).getRoute(),
                    solutionVehicles.get(i).getRoute()
            );
        }
    }


    @Test
    void testSolutionTwoVehicleTwoPassengers() {
        ICityState newCityState = setupOneVehicleForOnePassenger(2);
        List<IVehicle> newCityStateVehicles = newCityState.getVehicles();
        List<IVehicle> solutionVehicles = controller.getSolution().getVehicles();
        for (int i = 0; i < state.getVehicles().size(); ++i) {
            assertIterableEquals(
                    newCityStateVehicles.get(i).getRoute(),
                    solutionVehicles.get(i).getRoute()
            );
        }
    }


    @Test
    void testSolutionThreeVehicleThreePassengers() {
        ICityState newCityState = setupOneVehicleForOnePassenger(3);
        List<IVehicle> newCityStateVehicles = newCityState.getVehicles();
        List<IVehicle> solutionVehicles = controller.getSolution().getVehicles();
        for (int i = 0; i < state.getVehicles().size(); ++i) {
            assertIterableEquals(
                    newCityStateVehicles.get(i).getRoute(),
                    solutionVehicles.get(i).getRoute()
            );
        }
    }


    /*
    @Test
    void testSolutionTwoVehicleOnePassenger() {
        IPassenger passenger = new Passenger(origin, destination);
        state.addVehicle(new Vehicle(1, farAway));
        state.addVehicle(new Vehicle(1, origin));
        state.addPoint(passenger);
        ICityState newCityState = new CityState();
        IVehicle newVehicle1 = new Vehicle(1, farAway);
        IVehicle newVehicle2 = new Vehicle(1, origin);
        newVehicle2.addRoute(passenger);
        newCityState.addVehicle(newVehicle1);
        newCityState.addVehicle(newVehicle2);
        List<IVehicle> newCityStateVehicles = newCityState.getVehicles();
        List<IVehicle> solutionVehicles = controller.getSolution().getVehicles();
        for (int i = 0; i < state.getVehicles().size(); ++i) {
            assertIterableEquals(
                    newCityStateVehicles.get(i).getRoute(),
                    solutionVehicles.get(i).getRoute()
            );
        }
    }
    */
}
