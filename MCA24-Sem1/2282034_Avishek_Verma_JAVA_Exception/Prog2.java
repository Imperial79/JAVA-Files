import java.util.Scanner;

/*2. Define an exception called “NoMatchFoundException” that is thrown when a string is
not equal to “University”. Write a program that uses this exception. */

class NoMatchFoundException extends Exception {
    NoMatchFoundException(String s) {
        super("No Match Found");
    }
}

public class Prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = sc.nextLine();
        sc.close();
        try {
            if (word.compareTo("University") == 0)
                System.out.println("Equal");
            else
                throw new NoMatchFoundException(word);
        } catch (NoMatchFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
