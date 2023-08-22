
/*1. Write an inheritance hierarchy for classes Quadrilateral, Trapezoid, Parallelogram, Rectangle and Square. Use Quadrilateral as the super class of the hierarchy. Specify the instance variables and methods for each class. The private instance variables of Quadrilateral should be the x-y coordinate pairs for the four endpoints of the Quadrilateral. Write a program that
instantiates objects of your classes and outputs each object&#39;s area (except Quadrilateral). */

public class Quadrilateral {
    int x[], y[];

    public void setData(int[] x, int[] y) {
        this.x = x;
        this.y = y;
    }
}

class Trapezoid extends Quadrilateral {
    int height;

    Trapezoid(int x[], int y[], int height) {
        setData(x, y);
        this.height = height;
    }

    public int area() {
        int d1 = (int) Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
        int d2 = (int) Math.sqrt((x[2] - x[3]) * (x[2] - x[3]) + (y[2] - y[3]) * (y[2] - y[3]));
        return (int) ((d1 + d2) * height) / 2;
    }
}

class Parallelogram extends Quadrilateral {
    int height;

    Parallelogram(int x[], int y[], int height) {
        setData(x, y);
        this.height = height;
    }

    public int area() {
        int d = (int) Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
        return d * height;
    }
}

class Rectangle extends Quadrilateral {

    Rectangle(int x[], int y[]) {
        setData(x, y);
    }

    public int area() {
        int d1 = (int) Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
        int d2 = (int) Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
        return d1 * d2;
    }
}

class Square extends Quadrilateral {

    Square(int x[], int y[]) {
        setData(x, y);
    }

    public int area() {
        int area = (int) Math.sqrt((x[0] - x[1]) * (x[0] - x[1]) + (y[0] - y[1]) * (y[0] - y[1]));
        return area;
    }
}

class TestRunner {
    public static void main(String[] args) {
        int[] x = new int[] { 1, 2, 3, 4 };
        int[] y = new int[] { 2, 3, 4, 5 };
        Trapezoid tz = new Trapezoid(x, y, 10);
        System.out.println("Area of Trapezoid: " + tz.area());
        Parallelogram pl = new Parallelogram(x, y, 10);
        System.out.println("Area of Parallelogram: " + pl.area());

        Rectangle rec = new Rectangle(x, y);
        System.out.println("Area of Rectangle: " + rec.area());

        Square sq = new Square(x, y);
        System.out.println("Area of Square: " + sq.area());

    }
}
