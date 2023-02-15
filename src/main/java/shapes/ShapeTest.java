package shapes;

public class ShapeTest {
    public static void main(String[] args) {
        /*
         * create a variable of the type Rectangle named box1 and assign it
         * a new instance of the Rectangle class with a width of 4 and a length of 5
         */
        Rectangle box1 = new Rectangle(5, 4);

        /*
         * verify that the getPerimeter and getArea methods return 18 and 20, respectively.
         */
        System.out.format("Rectangle perimiter: %s%n", box1.getPerimiter());
        System.out.format("Rectangle area: %s%n", box1.getArea());

        /*
         * create a variable of the type Rectangle named box2 and assign it
         * a new instance of the Square class that has a side value of 5.
         */
        Quadrilateral box2 = new Square(5);

        /*
         * verify that the getPerimeter and getArea methods return 20 and 25, respectively.
         */
        System.out.format("Quadrilateral Square perimiter: %s%n", box2.getPerimiter());
        System.out.format("Quadrilateral Square area: %s%n", box2.getArea());

        Measurable myShape = new Square(5);
        System.out.format("Measurable Square perimiter: %s%n", myShape.getPerimiter());
        System.out.format("Measurable Square area: %s%n", myShape.getArea());

        myShape = new Rectangle(5, 4);
        System.out.format("Measurable Rectangle perimiter: %s%n", myShape.getPerimiter());
        System.out.format("Measurable Rectangle area: %s%n", myShape.getArea());
    }
}
