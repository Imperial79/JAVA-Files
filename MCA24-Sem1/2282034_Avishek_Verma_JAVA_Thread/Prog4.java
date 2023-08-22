public class Prog4 extends Thread {
    Prog4() {
        System.out.println("From Prog4 Constructor");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Shut Down ...");
    }

    @Override
    public void run() {
        System.out.println("Hello World 1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World 2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World 3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Prog4 t1 = new Prog4();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.gc();
                System.runFinalization();
                System.out.println("called garbage collector...");
            }
        };

        t1.start();
        t2.start();
    }
}
