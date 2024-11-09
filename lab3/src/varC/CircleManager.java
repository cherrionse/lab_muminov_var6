package varC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleManager {
    private List<Circle> circles;

    public CircleManager() {
        circles = new ArrayList<>();
    }

    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    // Поиск окружности с максимальной площадью
    public Circle getCircleWithMaxArea() {
        return circles.stream().max((c1, c2) -> Double.compare(c1.getArea(), c2.getArea())).orElse(null);
    }

    // Поиск окружности с минимальной площадью
    public Circle getCircleWithMinArea() {
        return circles.stream().min((c1, c2) -> Double.compare(c1.getArea(), c2.getArea())).orElse(null);
    }

    // Поиск окружности с максимальным периметром
    public Circle getCircleWithMaxPerimeter() {
        return circles.stream().max((c1, c2) -> Double.compare(c1.getPerimeter(), c2.getPerimeter())).orElse(null);
    }

    // Поиск окружности с минимальным периметром
    public Circle getCircleWithMinPerimeter() {
        return circles.stream().min((c1, c2) -> Double.compare(c1.getPerimeter(), c2.getPerimeter())).orElse(null);
    }

    // Определение групп окружностей с центрами на одной прямой
    public List<List<Circle>> findCollinearGroups() {
        List<List<Circle>> groups = new ArrayList<>();
        for (int i = 0; i < circles.size(); i++) {
            List<Circle> group = new ArrayList<>();
            Circle baseCircle = circles.get(i);
            group.add(baseCircle);
            for (int j = i + 1; j < circles.size(); j++) {
                Circle otherCircle = circles.get(j);
                if (areCollinear(baseCircle, otherCircle)) {
                    group.add(otherCircle);
                }
            }
            if (group.size() > 1) {
                groups.add(group);
            }
        }
        return groups;
    }

    // Проверка на коллинеарность центров двух окружностей
    private boolean areCollinear(Circle c1, Circle c2) {
        double slope1 = c1.getCenterY().toDouble() - c2.getCenterY().toDouble();
        double slope2 = c1.getCenterX().toDouble() - c2.getCenterX().toDouble();
        return slope1 == 0 || slope2 == 0 || slope1 / slope2 == c2.getCenterY().toDouble() / c2.getCenterX().toDouble();
    }

    public static void main(String[] args) {
        CircleManager manager = new CircleManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество окружностей:");
        int numCircles = scanner.nextInt();

        for (int i = 0; i < numCircles; i++) {
            System.out.println("Введите данные для окружности " + (i + 1) + ":");

            System.out.print("Числитель x-координаты центра: ");
            int xNumerator = scanner.nextInt();
            System.out.print("Знаменатель x-координаты центра: ");
            int xDenominator = scanner.nextInt();
            Rational xCenter = new Rational(xNumerator, xDenominator);

            System.out.print("Числитель y-координаты центра: ");
            int yNumerator = scanner.nextInt();
            System.out.print("Знаменатель y-координаты центра: ");
            int yDenominator = scanner.nextInt();
            Rational yCenter = new Rational(yNumerator, yDenominator);

            System.out.print("Радиус окружности: ");
            double radius = scanner.nextDouble();

            manager.addCircle(new Circle(xCenter, yCenter, radius));
        }

        System.out.println("Окружность с наибольшей площадью: " + manager.getCircleWithMaxArea());
        System.out.println("Окружность с наименьшей площадью: " + manager.getCircleWithMinArea());

        scanner.close();
    }
}
