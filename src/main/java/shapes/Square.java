package shapes;

public class Square extends Rectangle {

    private final double side;
    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimiter() {
        return side * 4;
    }

}
