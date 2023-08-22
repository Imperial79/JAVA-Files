/*
5. Write a program that outputs the name of the capital of the country entered at the
command line. The program should throw a “NoMatchFoundException” when it fails to
print the capital of the country entered at the command line.
 */

import java.util.Scanner;

class NoMatchFoundException extends Exception {
    public NoMatchFoundException(String s) {
        super(s);
    }
}

public class Prog5 {
    public static void main(String[] args) {
        String s;
        int c = 0;
        String country[] = { "India", "Malaysia", "Indonesia", "China", "Japan", "South Korea" };
        String cap[] = { "Delhi", "Kuala Lumpur", "Jakarta", "Beijing", "Tokyo", "Seoul" };
        System.out.println("Enter the name of the capital = ");
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        sc.close();
        for (int i = 0; i < country.length; i++) {
            if (s.equals(country[i])) {
                System.out.println(cap[i]);
                c = 1;
            }
        }
        try {
            if (c == 0) {
                throw new NoMatchFoundException("Match not Found");
            }
        } catch (NoMatchFoundException e) {
            System.out.println(e);
        }
        sc.close();
    }
}
