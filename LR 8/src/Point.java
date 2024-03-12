public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Point other) {
		return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Point)) return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}