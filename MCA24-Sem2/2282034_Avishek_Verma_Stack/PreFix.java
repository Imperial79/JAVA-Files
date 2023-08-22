import java.util.Scanner;

/*4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single digit number as a input) */

class PreFix {
    static String evaluate(String exp) {
        String ch = "";
        int n = exp.length(), top = -1;
        String stk[] = new String[n];

        for (int i = n - 1; i >= 0; i--) {
            // accessing elements in reverse manner
            ch = String.valueOf(exp.charAt(i));

            if (ch.matches("[0-9]")) {
                top += 1;
                stk[top] = ch;
            } else {
                int b = Integer.parseInt(stk[top]);
                top--;
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
        System.out.println("Enter a prefix expression: ");
        String exp = sc.nextLine();
        System.out.println(exp + " = " + PreFix.evaluate(exp));
        sc.close();
    }
}
