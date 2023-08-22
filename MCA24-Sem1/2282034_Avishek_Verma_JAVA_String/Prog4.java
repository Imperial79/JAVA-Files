import java.util.Scanner;

/*4. Write a program to accept a string from the user and find out the following statistics:
(a) Count of uppercase character
(b) Count of lowercase character
(c) Count of digits
(d) Count of spaces
 */

public class Prog4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int upChar = 0, loChar = 0, dig = 0, space = 0;
        System.out.println("Enter Line: ");
        String line = sc.nextLine();
        String[] arr = new String[line.split(" ").length];
        arr = line.split("");
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i].charAt(0))) {
                upChar++;
            } else if (Character.isLowerCase(arr[i].charAt(0))) {
                loChar++;
            } else if (Character.isDigit(arr[i].charAt(0))) {
                dig++;
            } else {
                space++;
            }
        }
        System.out.println("1. UpperCase Characters: " + upChar);
        System.out.println("2. LowerCase Characters: " + loChar);
        System.out.println("3. Digits: " + dig);
        System.out.println("4. Spaces: " + space);
        sc.close();
    }
}
