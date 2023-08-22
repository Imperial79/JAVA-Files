import java.util.Scanner;

/*
 * 1. Write a program called Factorial.java that computes factorials and catches
 * the result in an array of type long for reuse. The long type of variable has
 * its own range. For example 20! Is as high as the range of long type. So check
 * the argument passes and “throw an exception”, if it is too big or too small.
 * If x is less than 0 throw an IllegalArgument Exception with a message “Value
 * of x must be positive”.If x is above the length of the array throw an
 * IllegalArgumentException with a message “Result will overflow”.Here x is the
 * value for which we want to find the factorial.
 */

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long fact = 1;

        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Value of x must be positive");
            } else if (num > 20) {

                throw new Exception("x is too big");

            } else {
                for (int i = 1; i <= num; i++) {
                    fact *= i;
                }
                System.out.println(fact);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}