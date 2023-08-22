/*1. Write a Java program that illustrates the use of the yield( ), start( ),stop( ),run ( ),
sleep( ), wait( ) and isAlive( ) methods. */

public class Prog1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }

    public static void main(String[] args) {
        Prog1 obj1 = new Prog1();
        Prog1 obj2 = new Prog1();
        obj1.start();
        obj2.start();
        System.out.println("Is alive? " + obj1.isAlive());
        System.out.println("Waiting...");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " in control");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

                System.out.println(e);
            }

        }

        System.out.println("Is alive? " + obj1.isAlive());

    }
}