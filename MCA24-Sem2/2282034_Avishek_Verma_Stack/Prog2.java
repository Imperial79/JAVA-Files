
/*
 2. Write a method in a separate class to check an expression is valid or not.
 */
import java.util.Scanner;

class Exp {
    static boolean isOperator(String ch) {
        if (ch.equals("+") || ch.equals("/") || ch.equals("-") || ch.equals("*"))
            return true;
        return false;
    }

    static boolean checkExpression(String exp) {
        int top = -1;
        String ch, next = "";
        int flag = 0;

        String stk[] = new String[exp.length()];

        for (int i = 0; i < exp.length(); i++) {

            // System.out.println(Arrays.toString(stk));
            // System.out.println("TOP = " + top);
            // System.out.println("i = " + i);

            ch = String.valueOf(exp.charAt(i));
            // if (top >= 1) {
            // last = String.valueOf(exp.charAt(top - 1));
            // }
            if (i < exp.length() - 1) {
                next = String.valueOf(exp.charAt(i + 1));
            }

            if (ch.equals("(") || ch.equals("{") || ch.equals("[") || ch.matches("[a-zA-Z]")) {
                top += 1;
                stk[top] = ch;
            }

            else if (isOperator(ch)) {
                if (next.matches("[a-zA-Z]")) {
                    top -= 1;
                    i += 1;
                } else if (next.equals("(") || next.equals("{") || next.equals("[")) {
                    top += 1;
                    stk[top] = ch;
                    top += 1;
                    stk[top] = next;
                    i += 1;
                }

            }

            if (ch.equals(")") || ch.equals("}") || ch.equals("]")) {
                if (top == -1)
                    return false;

                if (stk[top].equals("(") && ch.equals(")") || stk[top].equals("{") &&
                        ch.equals("}")
                        || stk[top].equals("[") && ch.equals("]")) {
                    top -= 1;

                }
            }
        }

        if (top != -1) {
            flag = 1;
        }

        if (flag == 0)
            return true;
        return false;
    }

}

public class Prog2 {

    public static void main(String[] args) {
        String exp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an expression: ");
        exp = sc.nextLine();
        sc.close();

        if (Exp.checkExpression(exp))
            System.out.println(exp + " is valid");
        else
            System.out.println(exp + " is invalid");
    }
}
