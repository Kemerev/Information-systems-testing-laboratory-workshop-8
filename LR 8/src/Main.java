import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.io.File;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println(new File(".").getAbsolutePath());
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя файла, содержащего данные о точках: ");
		String filename = scanner.nextLine();

		List<String> lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
		List<Point> points = parsePointsData(lines);

		Triangle triangleWithMaxSquare = findTriangleWithMaxSquare(points);
		System.out.println("Треугольник с максимальной площадью определяется следующими точками: ");
		System.out.println(triangleWithMaxSquare.getPoint1());
		System.out.println(triangleWithMaxSquare.getPoint2());
		System.out.println(triangleWithMaxSquare.getPoint3());
		System.out.println("Его квадрат равен: " + triangleWithMaxSquare.square());

	}

	private static List<Point> parsePointsData(List<String> lines) {
		List<Point> result = new ArrayList<>(lines.size());
		for (String line : lines) {
			List<Double> coords = Arrays.stream(line.trim().split("\\s+"))
					.map(Double::valueOf)
					.collect(Collectors.toList());
			result.add(new Point(coords.get(0), coords.get(1)));
		}
		return result;
	}

	private static Triangle findTriangleWithMaxSquare(List<Point> points) {
		Triangle res = null;
		double curMaxSquare = 0;
		for (Point point1 : points) {
			for (Point point2 : points) {
				if (point1.equals(point2)) continue;
				for (Point point3 : points) {
					if (point3.equals(point1) || point3.equals(point2)) continue;
					Triangle tri = new Triangle(point1, point2, point3);
					double square = tri.square();
					if (square > curMaxSquare) {
						res = tri;
						curMaxSquare = square;
					}
				}
			}
		}
		return res;
	}
}