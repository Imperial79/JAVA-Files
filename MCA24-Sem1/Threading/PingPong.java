import java.util.Random;

class Ping extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.print("ping");
            Random r = new Random();
            for (int i = 0; i < r.nextInt(100); i++) {
                System.out.print(" ");
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

class Pong extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.print("PONG");
            Random r = new Random();
            for (int i = 0; i < r.nextInt(100); i++) {
                System.out.print(" ");
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class PingPong {
    public static void main(String[] args) {
        Ping pi = new Ping();
        Pong po = new Pong();

        pi.start();
        po.start();

    }

}