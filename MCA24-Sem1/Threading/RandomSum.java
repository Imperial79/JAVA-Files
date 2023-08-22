import java.util.Date;
import java.util.Random;

public class RandomSum extends Thread {
    int sum = 0;

    public static void main(String[] args) {
        RandomSum rs = new RandomSum() {
            @Override
            public void run() {
                while (true) {
                    Random r = new Random();
                    Date d = new Date();
                    sum += r.nextInt(20);
                    System.out.println(d);
                    System.out.println("Sum: " + sum);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        };

        rs.start();
    }
}
