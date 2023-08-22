import java.util.*;

public class Prog7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter character: ");
                char ch = sc.nextLine().charAt(0);

                if (ch >= 'a' && ch <= 'z') {
                } else {
                    throw new Exception("Not an alphabet");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        sc.close();
    }
}