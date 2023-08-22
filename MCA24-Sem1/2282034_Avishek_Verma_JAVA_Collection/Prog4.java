/*4. Write a program to find whether an array is subset of another array or not. */

import java.util.ArrayList;

public class Prog4 {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(2);
        a.add(5);
        a.add(1);
        a.add(3);
        a.add(6);
        a.add(17);

        b.add(1);
        b.add(3);
        b.add(2);
        b.add(17);

        if (a.containsAll(b)) {
            System.out.println("B is a subset of A");
        }

        else {
            System.out.println("B is not a subset of A");
        }

    }
}
