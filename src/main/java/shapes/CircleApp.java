package shapes;

import util.Input;

public class CircleApp {
    public static void main(String[] args) {
        Input input = new Input();
        do {
            double radius = input.getDouble("Enter the radius of a circle: ");
            Circle circle = new Circle(radius);
            System.out.format("Area: %f%n", circle.getArea());
            System.out.format("Circumference: %f%n", circle.getCircumference());
        } while (input.yesNo());
        String plurality = Circle.getInstances() == 1 ? "circle" : "circles";
        System.out.format("You created %d %s. Goodbye!%n", (int) Circle.getInstances(), plurality);

    }
}
