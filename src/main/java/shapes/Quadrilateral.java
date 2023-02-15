package shapes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Quadrilateral extends Shape implements Measurable {

    @NonNull
    protected double length;
    @NonNull
    protected double width;

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public abstract void setLength(double length);

    public abstract void setWidth(double width);

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimiter() {
        return 2 * length + 2 * width;
    }
}
