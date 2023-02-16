package shapes;

public class Square extends Quadrilateral {

    public Square(double side) {
        super(side, side);
    }

    public void setLength(double side) {
        setSide(side);
    }

    public void setWidth(double side) {
        setSide(side);
    }

    private void setSide(double side) {
        length = side;
        width = side;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimiter() {
        return 2 * length + 2 * width;
    }

}
