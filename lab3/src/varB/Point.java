package varB;

public class Point {
    private double x; // Координата X
    private double y; // Координата Y
    private double z; // Координата Z (если рассматриваем пространство)
    private double t; // Время

    // Конструктор для 2D-точки с временем
    public Point(double x, double y, double t) {
        this.x = x;
        this.y = y;
        this.z = 0; // Z по умолчанию равен 0 для 2D
        this.t = t;
    }

    // Конструктор для 3D-точки с временем
    public Point(double x, double y, double z, double t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    // Геттеры и сеттеры для полей
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public double getT() { return t; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    public void setT(double t) { this.t = t; }

    // Метод для вычисления скорости между двумя точками
    public double getSpeed(Point other) {
        double distance = this.distanceTo(other);
        double deltaTime = Math.abs(other.getT() - this.getT());
        if (deltaTime == 0) {
            throw new ArithmeticException("Время не изменилось, скорость неопределена.");
        }
        return distance / deltaTime;
    }

    // Метод для вычисления ускорения между двумя точками
    public static double getAcceleration(Point p1, Point p2, Point p3) {
        double v1 = p1.getSpeed(p2);
        double v2 = p2.getSpeed(p3);
        double deltaV = v2 - v1;
        double deltaT = p3.getT() - p1.getT();
        if (deltaT == 0) {
            throw new ArithmeticException("Время не изменилось, ускорение неопределено.");
        }
        return deltaV / deltaT;
    }

    // Метод для вычисления расстояния до другой точки
    public double distanceTo(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        double dz = this.z - other.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Метод для проверки пересечения траекторий двух точек
    public boolean trajectoriesIntersect(Point other) {
        return this.x == other.getX() && this.y == other.getY() && this.z == other.getZ() && this.t == other.getT();
    }

    // Метод для задания движения точки (изменение координат)
    public void move(double deltaX, double deltaY, double deltaZ, double deltaT) {
        this.x += deltaX;
        this.y += deltaY;
        this.z += deltaZ;
        this.t += deltaT;
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", t=" + t +
                '}';
    }
}
