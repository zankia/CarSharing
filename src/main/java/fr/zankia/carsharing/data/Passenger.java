package fr.zankia.carsharing.data;


/*
 * A passenger is the customer, the person want be take by a car.
 * A passenger is a specific type of CrossingPoint that is why
 * this class extends the class CrossingPoint.
 * @since 0.1 
 */
public class Passenger extends CrossingPoint {

	
	// The destination of the Passenger.
	private Destination dest;

	
	/*
	 * Getter of the destination.
	 * @return the passenger's destination
	 */
	public Destination getDestination() {
		return dest;
	}

	
	/*
	 * Setter of the passenger's destination.
	 * @param dest the destination to set
	 */
	public void setDestination(Destination dest) {
		this.dest = dest;
	}
	
	
	/*
	 * Constructor of a passenger.
	 * @param x a float will be the coordX of the passenger
	 * @param y a float will be the coordY of the passenger
	 */
	public Passenger(float x, float y) {
		
		//Call to the constructor of the super class (CrossingPoint).
		super(x, y);
	}
	
	
}
