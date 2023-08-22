/*
2. Write a program that uses a StringTokenizer to tokenize a line of text input by the user and places
each token in a treeSet. Print the elements of the treeSet. [Note: This should cause the elements to be
printed in ascending sorted order.]
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Line: ");
        String line = sc.nextLine();
        sc.close();
        StringTokenizer st = new StringTokenizer(line);
        TreeSet<String> ts = new TreeSet<String>();
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        System.out.println(ts);
    }
}
