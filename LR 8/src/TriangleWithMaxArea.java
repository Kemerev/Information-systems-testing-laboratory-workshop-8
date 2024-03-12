import java.util.*;

public final class TriangleWithMaxArea {
	private TriangleWithMaxArea() {}

	public static Triangle getTriangleWithMaxArea(List<Point> points) {
		if (points.size() < 3) {
			throw new IllegalArgumentException("Недостаточно точек, чтобы образовать треугольник.");
		}

		double maxArea = Double.NEGATIVE_INFINITY;
		int indexA = -1;
		int indexB = -1;
		int indexC = -1;

		for (int i = 0; i < points.size(); i++) {
			Point pointA = points.get(i);

			for (int j = i + 1; j < points.size(); j++) {
				Point pointB = points.get(j);

				for (int k = j + 1; k < points.size(); k++) {
					Point pointC = points.get(k);

					if (i == j || i == k || j == k) continue;

					double area = calculateTriangleArea(pointA, pointB, pointC);

					if (area > maxArea) {
						maxArea = area;
						indexA = i;
						indexB = j;
						indexC = k;
					}
				}
			}
		}

		Point p1 = points.get(indexA);
		Point p2 = points.get(indexB);
		Point p3 = points.get(indexC);

		return new Triangle(p1, p2, p3);
	}

	private static double calculateTriangleArea(Point a, Point b, Point c) {
		double ab = DistanceCalculator.calculateDistance(a, b);
		double bc = DistanceCalculator.calculateDistance(b, c);
		double ca = DistanceCalculator.calculateDistance(c, a);

		double s = (ab + bc + ca) / 2;

		return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
	}
}