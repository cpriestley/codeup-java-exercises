package shapes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle {
    protected double length;
    protected double width;

    public double getArea() {
        return length * width;
    }

    public double getPerimiter() {
        return 2 * length + 2 * width;
    }
}
