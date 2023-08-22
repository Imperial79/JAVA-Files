/*8. Write a class Polynomial to perform the following
a. Design a constructer to represent a polynomial (of single variable x).
b. Create a method to addition of polynomials.
c. Create a method to subtraction of polynomials.
d. Create a method to multiply of polynomials.
e. Create a method to find derivative of the polynomial. */

import java.util.ArrayList;
import java.util.List;

class Polynomial {
    private List<Integer> cf;

    public Polynomial(int dg) {
        this.cf = new ArrayList<>();
        for (int i = 0; i <= dg; i++)
            cf.add(0);
    }

    public Polynomial(int c, int dg) {
        this.cf = new ArrayList<>();
        for (int i = 0; i < dg; i++)
            cf.add(0);
        cf.add(c);
    }

    @Override
    public String toString() {
        String s = "";
        int t;
        for (int i = cf.size() - 1; i > 0; i--) {
            t = cf.get(i);
            if (t == 0)
                continue;
            if (i == 1)
                s += t + "x + ";
            else
                s += t + "x^" + i + " + ";
        }
        if (cf.get(0) != 0)
            return s += cf.get(0);
        return s.substring(0, s.length() - 3);
    }

    int deg() {
        for (int i = cf.size() - 1; i >= 0; i--)
            if (cf.get(i) != 0)
                return i;
        return 0;
    }

    void add(Polynomial p) {
        int n = Math.min(this.deg(), p.deg()), t;
        for (int i = 0; i <= n; i++) {
            t = this.cf.get(i) + p.cf.get(i);
            this.cf.set(i, t);
        }
        for (int i = n + 1; i < p.cf.size(); i++)
            this.cf.add(p.cf.get(i));
    }

    void sub(Polynomial p) {
        int n = Math.min(this.deg(), p.deg()), t;
        for (int i = 0; i <= n; i++) {
            t = this.cf.get(i) - p.cf.get(i);
            this.cf.set(i, t);
        }
        for (int i = n + 1; i < p.cf.size(); i++)
            this.cf.add(-1 * p.cf.get(i));
    }

    Polynomial multiply(Polynomial p) {
        int dg = this.deg() + p.deg(), t;

        Polynomial x = new Polynomial(dg);

        for (int i = 0; i <= this.deg(); i++)
            for (int j = 0; j <= p.deg(); j++) {
                t = x.cf.get(i + j);
                t += this.cf.get(i) * p.cf.get(j);
                x.cf.set(i + j, t);
            }

        return x;
    }

    Polynomial drv() {
        Polynomial x = new Polynomial(this.deg() - 1);

        int t;
        for (int i = this.deg(); i > 0; i--) {
            t = this.cf.get(i) * i;
            x.cf.set(i - 1, t);
        }

        return x;
    }
}

public class Prog8 {
    public static void main(String[] args) {
        Polynomial a = new Polynomial(3, 2);
        System.out.println("A: " + a);
        Polynomial b = new Polynomial(4, 1);
        System.out.println("B: " + b);
        b.add(a);
        System.out.println("B (updated) = B+A: " + b);
        Polynomial c = new Polynomial(1, 1);
        c.add(new Polynomial(1, 0));
        System.out.println("C: " + c);
        Polynomial d = b.multiply(c);
        System.out.println("D = B*C: " + d);
        System.out.println("D': " + d.drv());
    }
}
