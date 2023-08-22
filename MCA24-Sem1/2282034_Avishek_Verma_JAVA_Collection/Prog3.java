/*3. Write a program that inputs the names of people into different array list, A and B. Array A has N
number of names while array B has M number of names, with no duplicates in either of them. Merge
arrays A and B into a single array list C, such that the resulting array list is sorted alphabetically.
Display all the three arrays list, A, B and C, stored alphabetically. */

import java.util.ArrayList;
import java.util.Collections;

public class Prog3 {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();

        a.add("Avishek");
        a.add("Vivek");
        a.add("Akash");
        a.add("Yash");

        b.add("Mohit");
        b.add("Zack");
        b.add("Tania");
        b.add("Somnath");

        c.addAll(a);
        c.addAll(b);
        Collections.sort(c);
        System.out.println(c);
    }
}
