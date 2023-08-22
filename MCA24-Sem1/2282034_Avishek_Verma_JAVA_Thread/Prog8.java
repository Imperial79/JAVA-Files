/*8. Write a program, which will create a deadlock. */

public class Prog8 {
    public static void main(String[] args) {
        final String resource1 = "RESOURCE1";
        final String resource2 = "RESOURCE2";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked " + resource1);

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: locked " + resource2);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked " + resource2);

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked " + resource1);
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}