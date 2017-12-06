package fr.zankia.carsharing.data;


/*
 * CrossingPoint is an object on a map through which a car will pass.
 * @since 0.1
 */
public class CrossingPoint {
	
	
	// coordX is the first coordinate of the CrossingPoint.
	private float coordX;
	
	
	// coordY is the second coordinate of the CrossingPoint.
	private float coordY;

	
	/*
	 * Getter of coordX.
	 * @return coordX of the current CrossingPoint
	 */
	public float getX() {
		return coordX;
	}

	
	/*
	 * Setter of coordX .
	 * @param coordX a float that want to put as 
	 * coordX of the CrossingPoint
	 */
	public void setX(float coordX) {
		this.coordX = coordX;
	}

	
	/*
	 * Getter of coordY.
	 * @return coordY of the current CrossingPoint
	 */
	public float getY() {
		return coordY;
	}
	
	
	/*
	 * Setter of coordY.
	 * @param coordY a float that want to put as 
	 * coordY of the CrossingPoint
	 */
	public void setY(float coordY) {
		this.coordY = coordY;
	}

	
	/*
	 * Constructor of a CrossingPoint.
	 * @param x a float that will be the coordX
	 * @param y a float that will be the coordY
	 */
	public CrossingPoint(float x, float y) {
		coordX = x;
		coordY = y;
	}
	
	
}
