/*5. Create a class containing an inner class that itself contains an inner class. Repeat this using
static inner class. What are the names of the .class files produced by the compiler? */

package Day2;

public class Outer {
    class Inner1 {
        class Inner2 {

        }
    }

    static class Inner3 {
        static class Inner4 {

        }
    }
}

/*
 * The .class files created by compiler are :-
 * Outer$Inner1$Inner2.class
 * Outer$Inner1.class
 * Outer.class
 * Outer1$Inner3$Inner4.class
 * Outer1$Inner3.class
 * Outer1.class
 */
