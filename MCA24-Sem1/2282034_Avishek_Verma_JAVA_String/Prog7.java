
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 7. Write a program to determine if a string has all Unique Characters.[remove white space]
Given a string, determine if the string has all unique characters.
Examples :
Input: ab cd 10jk
Output: true
Input: hutg9mnd!nk9
Output: false
 */

public class Prog7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line: ");
        String line = sc.nextLine();

        List<String> lst = Arrays.asList(line.replaceAll(" ", "").split(""));
        Set<String> mySet = new HashSet<String>();

        for (String element : lst) {
            mySet.add(element);
        }

        if (lst.size() != mySet.size())
            System.out.println("False");
        else
            System.out.println("True");

        sc.close();
    }
}
