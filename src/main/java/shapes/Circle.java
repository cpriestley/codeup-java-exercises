package shapes;

public class Circle {
    private final double radius;
    private static double instances = 0;

    public Circle(double radius) {
        this.radius = radius;
        instances = getInstances() + 1;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public static double getInstances() {
        return instances;
    }
}
