/*6. Suppose that two threads “t1” and “t2” access a shared integer “x”. Thread “t1”
indefinitely increases “x” and “t2” indefinitely prints the value of “x”. That is the
threads run in an infinite loop. However, thread “t1” must not increase “x” till that
value of “x” is printed by “t2” and “t2” must not print the same value of “x” more
than once. */

/*7. Define the classes for implementing “t1” and “t2”. Write appropriate methods for
accomplishing the above. */

class Val {
    int x;
    boolean isIncrement = false;

    Val() {
        x = 0;
    }

    synchronized void increment() {

        if (isIncrement) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        x++;
        isIncrement = true;
        notify();
    }

    synchronized void printVal() {
        if (!isIncrement) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("x = " + x);
        isIncrement = false;
        notify();
    }
}

public class Prog6_7 {
    public static void main(String[] args) {
        Val x = new Val();

        Thread display = new Thread() {
            @Override
            public void run() {
                while (true) {
                    x.increment();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };

        Thread incre = new Thread() {
            @Override
            public void run() {
                while (true) {
                    x.printVal();
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };
        display.start();
        incre.start();

    }
}
