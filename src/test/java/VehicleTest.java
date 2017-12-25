import fr.zankia.carsharing.model.Passenger;
import fr.zankia.carsharing.model.Vehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class VehicleTest {
    private Vehicle vehicle;
    private Passenger pSameLocation, pNear, pFar;
    private Point2D.Float origin, destination;

    @BeforeAll
    public void setUp() {
        origin = new Point2D.Float(0, 0);
        destination = new Point2D.Float(0, 1);
        vehicle = new Vehicle(4, origin);
        pSameLocation = new Passenger(origin, destination);
        pNear = new Passenger(new Point2D.Float(1, 0), new Point2D.Float(2, 0));
        pFar = new Passenger(new Point2D.Float(4, 0), new Point2D.Float(5, 0));
    }


    @Test
    public void testPassengerLocationPickup() {
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
    public void testPassengerLocationDropoff() {
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
    public void testaddPassenger(RepetitionInfo info) {
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
    public void testNearFirst() {
        vehicle.clear();
        vehicle.addRoute(pFar);
        vehicle.addRoute(pNear);
        assertEquals(pNear.getLocation(), vehicle.getNextWaypoint(),
                "should select nearest at the top of the route");
    }


    @Test
    public void testCost() {
        vehicle.clear();
        vehicle.addRoute(pNear);
        assertEquals(2, vehicle.getCost(),
                "cost should be 2 for the nearest passenger");
        vehicle.addRoute(pFar);
        assertEquals(5, vehicle.getCost(),
                "cost should be 5 for the two passengers");
    }

}
