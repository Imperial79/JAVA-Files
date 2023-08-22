
/*5. Write a method in a separate class to convert an infix expression to its corresponding postfix expression. */

class IntoPost {

    static boolean isOperator(String ch) {
        if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
            return true;
        return false;
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

    static boolean isVariable(String ch) {
        if (ch.matches("[a-zA-Z]"))
            return true;
        return false;
    }

    static String convert(String exp) {
        int n = exp.length(), top = -1;
        String ch = "", post = "";
        String stk[] = new String[n];
        for (int i = 0; i < n; i++) {
            ch = String.valueOf(exp.charAt(i));
            if (isVariable(ch)) {
                post += ch;
            } else if (isOperator(ch)) {
                // first operator detected
                if (top == -1) {
                    top += 1;
                    stk[top] = ch;
                }
                // if already some operators are there, check their precedence with current one
                else {
                    while (top >= 0 && preceed(stk[top]) >= preceed(ch)) {
                        // remove elements from stack and add into post
                        post += stk[top];
                        top--;
                    }
                    top++;
                    stk[top] = ch;
                }
            }
        }
        // pop the remaining operators from the stack
        for (int i = top; i >= 0; i--) {
            post += stk[i];
        }
        return post;
    }
}

public class Prog5 {
    public static void main(String[] args) {
        String exp = "a+b*c+d";
        System.out.println(exp + " -> " + IntoPost.convert(exp));
    }

}
