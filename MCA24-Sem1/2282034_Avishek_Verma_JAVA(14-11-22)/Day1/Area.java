
/*
3. Write a program to print the area of a rectangle by creating a class named 'Area' having two methods. First method named as 'setDim' takes length and breadth of rectangle as parameters
and the second method named as 'getArea' returns the area of the rectangle. Length and breadth of rectangle are entered through keyboard.

*/
package Day1;

import java.util.Scanner;

public class Area {
    int len, bre;

    public void setDim(int l, int b) {
        this.len = l;
        this.bre = b;
    }

    public int getArea() {
        return len * bre;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length & Breadth to a rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();

        Area ar = new Area();
        ar.setDim(l, b);
        System.out.println("Area: " + ar.getArea());

        sc.close();
    }
}
