package main.java.fr.zankia.carsharing.data;

public class Passenger extends CrossingPoint {

	private Destination dest;

	public Destination getDestination() {
		return dest;
	}

	public void setDestination(Destination dest) {
		this.dest = dest;
	}

	public Passenger(float x, float y) {
		super(x, y);
	}
}
