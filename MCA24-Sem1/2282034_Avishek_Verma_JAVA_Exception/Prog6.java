import java.util.Scanner;

/*
6. Write a program that takes a value at the command line for which factorial is to be
computed. The program must convert the string to its integer equivalent. There are three
possible user input errors that can prevent the program from executing normally.
The first error is when the user provides no argument while executing the program and an
ArrayIndexOutOfBoundsException is raised. You must write a catch block for this.
The second error is NumberFormalException that is raised in case the user provides a
non-integer (float double) value at the command line.The third error is IllegalArgument
Exception. This needs to be thrown manually if the value at the command line is 0.
 */

public class Prog6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        String num = sc.nextLine();
        sc.close();

        int fact = 1;

        try {
            if (num.equals("")) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (num.contains(".")) {
                throw new NumberFormatException();
            } else if (num.equals("0")) {
                throw new IllegalArgumentException();
            } else {
                int n = Integer.parseInt(num);
                for (int i = 1; i <= n; i++) {
                    fact *= i;
                }
                System.out.println(fact);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}
