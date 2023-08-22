/*
5. Create two Thread subclasses, one with a run( ) that starts up, captures the
reference of the second Thread object and then calls wait( ). The other class’
run( ) should call notifyAll( ) for the first thread after some number of seconds
have passed, so the first thread can print a message.
 */

class Resource {
    synchronized void waiter() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }

    synchronized void notifier() {
        notifyAll();
    }
}

class Waiter extends Thread {
    Thread t;
    Resource r;

    public Waiter(Thread t, Resource r) {
        this.t = t;
        this.r = r;
    }

    @Override
    public void run() {
        t.start();
        System.out.println("Waiting...");
        r.waiter();
        System.out.println("Waiting Over");
    }
}

class Notifier extends Thread {
    Resource r;

    public Notifier(Resource r) {
        this.r = r;
    }

    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Notifying...");
        r.notifier();
    }
}

public class Prog5 {
    public static void main(String[] args) {

        Resource r = new Resource();

        Notifier n = new Notifier(r);

        new Waiter(n, r).start();
    }
}
