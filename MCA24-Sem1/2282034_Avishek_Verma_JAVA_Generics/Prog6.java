/*6. Write a methods [double operation(double a, double b)]; ] that return a lambda expression implement a calculator perform Addition, Subtraction, Division, Multiplication operation. */

public class Prog6 {
    interface Calculate {
        public double value(double a, double b);
    }

    double operation(double a, double b, String op) {
        Calculate add = (num1, num2) -> {
            return num1 + num2;
        };
        Calculate sub = (num1, num2) -> {
            return num1 - num2;
        };
        Calculate mul = (num1, num2) -> {
            return num1 * num2;
        };
        Calculate div = (num1, num2) -> {
            return num1 / num2;
        };
        if (op.equals("add")) {
            return add.value(a, b);
        } else if (op.equals("sub")) {
            return sub.value(a, b);
        } else if (op.equals("mul")) {
            return mul.value(a, b);
        } else {
            return div.value(a, b);
        }
    }

    double add(double a, double b) {
        return operation(a, b, "add");
    }

    double sub(double a, double b) {
        return operation(a, b, "sub");
    }

    double mul(double a, double b) {
        return operation(a, b, "mul");
    }

    double div(double a, double b) {
        return operation(a, b, "div");
    }

    public static void main(String[] args) {
        Prog6 pg = new Prog6();

        System.out.println("Addition: " + pg.add(2, 2));
        System.out.println("Substraction: " + pg.sub(21, 5));
        System.out.println("Multiplication: " + pg.mul(23, 20));
        System.out.println("Division: " + pg.div(22, 2));
    }
}
