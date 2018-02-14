import fr.zankia.carsharing.model.IPassenger;
import fr.zankia.carsharing.model.Passenger;
import fr.zankia.carsharing.model.Vehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class VehicleTest {
    private Vehicle vehicle;
    private IPassenger pSameLocation, pNear, pFar, pInvertedDest;
    private Point2D origin, destination;

    @BeforeAll
    void setUp() {
        origin = new Point2D.Float(0, 0);
        destination = new Point2D.Float(0, 1);
        vehicle = new Vehicle(4, origin);
        pSameLocation = new Passenger(origin, destination);
        pNear = new Passenger(new Point2D.Float(1, 0), new Point2D.Float(3, 0));
        pFar = new Passenger(new Point2D.Float(4, 0), new Point2D.Float(5, 0));
        pInvertedDest = new Passenger(new Point2D.Float(3, 0), origin);
    }


    @Test
    void testPassengerLocationPickup() {
        vehicle.clear();
        assertTrue(vehicle.addPassenger(pSameLocation),
                "should add a passenger in the same location");
        assertFalse(vehicle.addPassenger(new Passenger(new Point2D.Float(1, 0))),
                "should not add a passenger in other location");
        assertFalse(vehicle.addPassenger(new Passenger(new Point2D.Float(0, 1))),
                "should not add a passenger in other location");
        assertFalse(vehicle.addPassenger(new Passenger(new Point2D.Float(1, 1))),
                "should not add a passenger in other location");
    }


    @Test
    void testPassengerLocationDropoff() {
        vehicle.clear();
        Passenger passenger = new Passenger(origin);
        vehicle.addPassenger(pSameLocation);
        vehicle.addPassenger(passenger);
        assertFalse(vehicle.removePassenger(passenger),
                "should not remove a passenger with no destination");
        assertFalse(vehicle.removePassenger(new Passenger(origin, origin)),
                "should not remove a passenger not in vehicle");
        assertFalse(vehicle.removePassenger(pSameLocation),
                "should not remove a passenger in other destination");
        vehicle.setLocation(destination);
        assertTrue(vehicle.removePassenger(pSameLocation),
                "should remove passenger on the rigth destination");
        vehicle.setLocation(origin);
    }


    @RepeatedTest(5)
    void testaddPassenger(RepetitionInfo info) {
        if (info.getCurrentRepetition() == 1) {
            vehicle.clear();
        }
        if (info.getCurrentRepetition() != info.getTotalRepetitions()) {
            assertTrue(vehicle.addPassenger(pSameLocation),
                    "should add a passenger");
        } else {
            assertThrows(IllegalStateException.class, () ->
                    vehicle.addPassenger(pSameLocation),
                    "should not add a passenger because vehicle is full");
        }
    }


    @Test
    void testNearFirst() {
        vehicle.clear();
        vehicle.addRoute(pFar);
        vehicle.addRoute(pNear);
        assertEquals(pNear.getLocation(), vehicle.getNextWaypoint(),
                "should select nearest at the top of the route");
    }


    @Test
    void testCost() {
        vehicle.clear();
        vehicle.addRoute(pNear);
        assertEquals(3, vehicle.getCost(),
                "cost should be 2 for the nearest passenger");
        vehicle.addRoute(pFar);
        assertEquals(5, vehicle.getCost(),
                "cost should be 5 for the two passengers");
    }


    @Test
    void testAddCloserDestination() {
        vehicle.clear();
        vehicle.addRoute(pNear);
        vehicle.addRoute(pInvertedDest);
        List<Point2D> solution = new LinkedList<>();
        solution.add(pNear.getLocation());
        solution.add(pNear.getDestination());
        solution.add(pInvertedDest.getLocation());
        solution.add(pInvertedDest.getDestination());
        assertIterableEquals(solution, vehicle.getRoute(),
                "should not add a destination before taking a passenger");
    }

    @Test
    void testAddCapacity() {
        vehicle.clear();
        List<Point2D> solution = new LinkedList<>();
        for(int i = 0; i < vehicle.getCapacity() + 1; ++i) {
            vehicle.addRoute(new Passenger(origin, destination));
        }
        solution.add(origin);
        solution.add(origin);
        solution.add(origin);
        solution.add(origin);
        solution.add(destination);
        solution.add(destination);
        solution.add(destination);
        solution.add(destination);
        solution.add(origin);
        solution.add(destination);
        assertIterableEquals(solution, vehicle.getRoute(),
                "should not take more passengers than capacity");
    }

}
