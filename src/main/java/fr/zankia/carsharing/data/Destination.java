package fr.zankia.carsharing.data;


/*
 * Destination is the point on a map where a passenger want to go
 * Destination is a specific type of CrossingPoint that is why
 * this class extends the class CrossingPoint
 * @since 0.1
 */
public class Destination extends CrossingPoint {

	
	/*
	 * Constructor of a destination.
	 * @param x a float that will be coordX of the destination
	 * @param y a float that will be coordY of the destination
	 */
	public Destination(float x, float y) {
		
		//call to the constructor of the super class (CrossingPoint).
		super(x, y);
		
	}
	
	
}
