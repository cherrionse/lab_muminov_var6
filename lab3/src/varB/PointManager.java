package varB;

import java.util.Scanner;

public class PointManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание выполнил: Муминов Рустам Б762-2");
        System.out.println("Введите координаты и время для точки 1:");
        Point p1 = createPoint(scanner);

        System.out.println("Введите координаты и время для точки 2:");
        Point p2 = createPoint(scanner);

        System.out.println("Введите координаты и время для точки 3:");
        Point p3 = createPoint(scanner);

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Точка 3: " + p3);

        double speed = p1.getSpeed(p2);
        System.out.println("Скорость между p1 и p2: " + speed);

        double acceleration = Point.getAcceleration(p1, p2, p3);
        System.out.println("Ускорение между p1, p2 и p3: " + acceleration);

        boolean intersect = p1.trajectoriesIntersect(p2);
        System.out.println("Пересекаются ли траектории p1 и p2? " + intersect);

        System.out.println("Введите значения для движения точки 1 (dx, dy, dz, dt):");
        double dx = scanner.nextDouble();
        double dy = scanner.nextDouble();
        double dz = scanner.nextDouble();
        double dt = scanner.nextDouble();

        p1.move(dx, dy, dz, dt);
        System.out.println("Точка 1 после движения: " + p1);

        scanner.close();
    }

    private static Point createPoint(Scanner scanner) {
        System.out.print("Введите x: ");
        double x = scanner.nextDouble();

        System.out.print("Введите y: ");
        double y = scanner.nextDouble();

        System.out.print("Введите z: ");
        double z = scanner.nextDouble();

        System.out.print("Введите t (время): ");
        double t = scanner.nextDouble();

        return new Point(x, y, z, t);
    }
}
