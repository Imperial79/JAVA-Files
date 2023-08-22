import java.util.Scanner;

/*3. Write a program that takes a String from the user on the command-line and print it in
reverse.
 “This is a test” must be printed as: “test a is This”. */

public class Prog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Line: ");
        String line = sc.nextLine();

        String[] arr = new String[line.split(" ").length];
        arr = line.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
