
public class Circle {

    double area, perimeter, r;

    public Circle(int radius) {
        this.r = radius;

    }

    public double area() {
        return Math.PI * r * r;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }
}
