import java.util.Scanner;

/*2. Write a Java class called CountAndPrintArgs to print the number of arguments passed on
the command-line as well as the 1st letter of the arguments. For example, if the command
line arguments are: “Mango Cucumber Apple” then the output will be
No. of arguments – 3 MCA
Write a main method to test the class.  */

public class Prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the line: ");
        String line = sc.nextLine();

        System.out.println("No. of arguments - " + line.split(" ").length);

        String[] arr = new String[line.split(" ").length];
        arr = line.split(" ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].charAt(0));
        }
        sc.close();
    }
}
