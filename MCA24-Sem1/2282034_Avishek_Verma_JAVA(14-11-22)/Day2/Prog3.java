/*3. Write a program that defines a class with one static variable called cnt. Create two or more
objects of the class. The class also contains a method that increments the cnt variable
whenever a new instance of the class is created. Write a driver class to test the above class. */
package Day2;

public class Prog3 {
    static int cnt = 0;

    Prog3() {
        cnt++; // increments when a new instance is created
    }

    public static int getCnt() {
        return cnt;
    }

    public static void main(String[] args) {
        new Prog3();
        new Prog3();
        new Prog3();
        int count = getCnt(); // fetching the value of cnt
        System.out.println("No. of instance created: " + count);
    }
}
