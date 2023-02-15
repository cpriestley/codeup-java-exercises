package shapes;

import lombok.NonNull;

public class Rectangle extends Quadrilateral implements Measurable {

    protected Rectangle(@NonNull double length, @NonNull double width) {
        super(length, width);
    }

    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

}
