package TCP;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket soc = new Socket("localhost", 1234);
        Scanner sc = new Scanner(System.in);
        System.out.println("Connected ..");
        System.out.println("-- type STOP to stop chat --");
        Scanner in;

        while (true) {
            System.out.println("Enter message: ");
            String msg = sc.nextLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream());

            if (msg.equals("STOP")) {
                break;
            } else {
                out.println(msg);
            }

            in = new Scanner(soc.getInputStream());
            System.out.println("Server: " + in.nextLine());

        }

        soc.close();
        sc.close();
    }
}
