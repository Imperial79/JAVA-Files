import java.util.Scanner;

/*
6. Write a method (not the entire application) called CountVowels, which takes the input
arguments as character and checks whether it is a vowel; increment the instance variable
called vCnt by 1.
 */

public class Prog6 {

    public static int CountVowels(String ch) {
        // String[] vowels = { "a", "e", "i", "o", "u" };

        if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u"))
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line: ");
        String line = sc.nextLine();
        String[] arr = new String[line.split("").length];
        arr = line.split("");
        int voCount = 0;

        for (int i = 0; i < arr.length; i++) {

            voCount += CountVowels(arr[i]);
        }

        System.out.println("Vowels Count: " + voCount);
        sc.close();
    }
}