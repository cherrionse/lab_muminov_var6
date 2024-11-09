package varC;

public class Circle {
    private Rational centerX; // Координата X центра
    private Rational centerY; // Координата Y центра
    private double radius;

    public Circle(Rational centerX, Rational centerY, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным.");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    // Метод для вычисления площади
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Метод для вычисления периметра
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Геттеры для центра
    public Rational getCenterX() { return centerX; }
    public Rational getCenterY() { return centerY; }

    @Override
    public String toString() {
        return "Circle{" +
                "center=(" + centerX + ", " + centerY + ")" +
                ", radius=" + radius +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
