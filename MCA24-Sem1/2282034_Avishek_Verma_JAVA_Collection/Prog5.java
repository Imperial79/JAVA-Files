import java.util.ArrayList;

/*
5. Write a program to find elements which are present in first array and not in second array.
 */

public class Prog5 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        a.add(2);
        a.add(5);
        a.add(1);
        a.add(3);
        a.add(6);
        c = a;

        b.add(1);
        b.add(3);
        b.add(2);
        System.out.println("A: " + a);
        System.out.println("B: " + b);

        System.out.println("Elements not in B - ");

        c.removeAll(b);
        System.out.println(c);

    }
}
