public class Triangle {
	private Point point1;
	private Point point2;
	private Point point3;

	public Triangle(Point point1, Point point2, Point point3) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	public double perimeter() {
		return point1.distance(point2) + point2.distance(point3) + point3.distance(point1);
	}

	public double square() {
		double halfPerimeter = perimeter() / 2;
		return Math.sqrt(halfPerimeter * (halfPerimeter - point1.distance(point2)) * (halfPerimeter - point2.distance(point3)) * (halfPerimeter - point3.distance(point1)));
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public Point getPoint3() {
		return point3;
	}
}