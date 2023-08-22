public class Square {
    double area, perimeter, a;

    Square(int side) {
        this.a = side;
    }

    double area() {
        return a * a;
    }

    double perimeter() {
        return 4 * a;
    }
}
