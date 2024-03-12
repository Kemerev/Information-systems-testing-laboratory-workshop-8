public final class DistanceCalculator {
	private DistanceCalculator() {}

	public static double calculateDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}
}