import java.util.Scanner;

/*3. Write a method in a separate class to evaluate a postfix expression (Consider more than single digit number as a input). */

class PostFix {
    static String evaluate(String exp) {

        String ch = "";
        int n = exp.length(), top = -1;
        String stk[] = new String[n];

        for (int i = 0; i < n; i++) {
            ch = String.valueOf(exp.charAt(i));

            if (ch.matches("[0-9]")) {
                // if number
                top += 1;
                stk[top] = ch;
            } else {
                // if operator
                int b = Integer.parseInt(stk[top]);
                top -= 1;
                int a = Integer.parseInt(stk[top]);
                switch (ch) {
                    case "+":
                        stk[top] = String.valueOf(a + b);
                        break;

                    case "*":
                        stk[top] = String.valueOf(a * b);
                        break;
                    case "/":
                        stk[top] = String.valueOf(a / b);
                        break;
                    case "-":
                        stk[top] = String.valueOf(a - b);
                        break;

                    default:
                        break;
                }
            }
        }

        if (top == 0)
            return stk[top];
        else
            return "Invalid";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String exp = sc.nextLine();
        System.out.println(exp + " = " + PostFix.evaluate(exp));
        sc.close();
    }
}
