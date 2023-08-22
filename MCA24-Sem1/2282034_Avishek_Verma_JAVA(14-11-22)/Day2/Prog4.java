/*4. Create a class with a private field and a private method. Create an inner class with a method
that modifies the outer class field and calls the outer class method. In a second outer class
method, create an object of the inner class and call it’s method, then show the effect on the
outer class object. */
package Day2;

public class Prog4 {
    private int a = 10;
    private int b = 20;

    private void add() {
        Prog4 c1 = new Prog4();
        System.out.printf("A+B = %d\n", c1.a + c1.b);
    }

    class Class2 {

        public void innerClassFunc() {
            add();

            // changing variable values
            a++;
            b++;
        }
    }

    public static void main(String[] args) {
        Prog4 c1 = new Prog4();
        Prog4.Class2 c2 = c1.new Class2();

        c2.innerClassFunc();
        System.out.println("A = " + c1.a);
        System.out.println("B = " + c1.b);

    }
}
