/*1. Write a Java program to pass the string “Have a nice day!” from the command line, and
display each word in a new line. Use proper import statement for this program. */

import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter line: ");
        String line = sc.nextLine();

        System.out.println(line.replaceAll(" ", "\n"));

        sc.close();
    }
}