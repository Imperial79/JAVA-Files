import java.util.Arrays;
import java.util.Scanner;

/*
5. Write a Java class called ArrayExample to declare an array of String objects called Products of the size 10, assign values to each element while declarations and print and sort them.
 */

public class Prog5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String products[] = new String[10];
        products[0] = "bread";
        products[1] = "butter";
        products[2] = "apple";
        products[3] = "mayonise";
        products[4] = "cucumber";
        products[5] = "potato";
        products[6] = "jam";
        products[7] = "banana";
        products[8] = "rice";
        products[9] = "basmati";

        System.out.println("Original array: " + Arrays.toString(products));
        Arrays.sort(products);
        System.out.println("Sorted array: " + Arrays.toString(products));
        sc.close();
    }
}
