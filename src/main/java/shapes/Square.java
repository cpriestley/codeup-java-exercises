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

}
