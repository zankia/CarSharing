package main.java.fr.zankia.carsharing.data;

public class CrossingPoint {
	private float coordX;
	private float coordY;

	public float getX() {
		return coordX;
	}

	public void setX(float coordX) {
		this.coordX = coordX;
	}

	public float getY() {
		return coordY;
	}

	public void setY(float coordY) {
		this.coordY = coordY;
	}

	public CrossingPoint(float x, float y) {
		coordX = x;
		coordY = y;
	}
}
