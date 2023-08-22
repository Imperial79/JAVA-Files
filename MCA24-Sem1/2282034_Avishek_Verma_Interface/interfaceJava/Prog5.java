public class Prog5 {
    public static void main(String[] args) {
        Circle cl = new Circle(10);
        Square sq = new Square(5);

        Triangle tr = new Triangle(4, 5, 6);
        System.out.println("Area of Circle = " + cl.area() + "\nPerimeter = " + cl.perimeter());
        System.out.println("Area of Square = " + sq.area() + "\nPerimeter = " + sq.perimeter());
        System.out.println("Area of Triangle = " + tr.area() + "\nPerimeter = " + tr.perimeter());
    }
}
