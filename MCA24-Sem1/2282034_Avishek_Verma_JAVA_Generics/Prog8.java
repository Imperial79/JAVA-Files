public class Prog8 {
    public static void main(String[] args) {
        Runnable th = () -> {
            System.out.println("Thread is started...");
        };

        Thread run = new Thread(th);
        run.start();
    }
}
