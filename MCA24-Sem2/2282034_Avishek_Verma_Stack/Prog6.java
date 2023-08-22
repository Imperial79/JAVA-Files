/*6. Write a method in a separate class to convert an infix expression to its corresponding prefix expression. */

class IntoPre {
    static boolean isOperator(String ch) {
        if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
            return true;
        return false;
    }

    static String reverseStr(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

    static int preceed(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

        }
        return -1;
    }

    static String convert(String exp) {
        int n = exp.length(), top = -1;
        String ch = "", pre = "";
        String stk[] = new String[n];
        exp = reverseStr(exp);

        for (int i = 0; i < n; i++) {
            ch = String.valueOf(exp.charAt(i));
            if (ch.matches("[a-zA-Z]")) {
                pre += ch;
            } else if (isOperator(ch)) {

                if (top == -1) {
                    top += 1;
                    stk[top] = ch;
                }

                else {
                    while (top >= 0 && preceed(stk[top]) >= preceed(ch)) {
                        pre += stk[top];
                        top -= 1;
                    }
                    top += 1;
                    stk[top] = ch;
                }
            }
        }
        for (int i = top; i > -1; i--) {
            pre += stk[i];
        }

        return reverseStr(pre);
    }

}

public class Prog6 {
    public static void main(String[] args) {
        String exp = "A*B+C/D";
        System.out.println(exp + " -> " + IntoPre.convert(exp));
    }
}
