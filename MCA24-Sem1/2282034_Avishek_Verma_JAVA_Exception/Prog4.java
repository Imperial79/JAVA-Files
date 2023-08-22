import java.util.Scanner;

/*
  4. Write a class that keeps a running total of all characters passed to it (one at a time) and throws an exception if it is passed a non-alphabetic character.
 */

class NonAlphaException extends Exception {
    NonAlphaException(char ch) {
        System.out.println(ch + " is not an alphabet");
    }
}

public class Prog4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;
        System.out.println("Enter Character: ");
        for (int i = 0; i < 5; i++) {
            try {
                ch = sc.next().charAt(0);
                if (ch >= 'a' && ch <= 'z') {
                    System.out.println(ch + " is an alphabet");
                } else
                    throw new NonAlphaException(ch);
            } catch (NonAlphaException e) {
                System.out.println(e.getMessage());
            }

        }
        sc.close();
    }
}
