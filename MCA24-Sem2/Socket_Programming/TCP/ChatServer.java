package TCP;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSoc = new ServerSocket(1234);
        Socket soc = serverSoc.accept();
        System.out.println("Connected ..");
        System.out.println("-- type STOP to stop chat --");
        Scanner sc = new Scanner(System.in);
        Scanner in;

        while (true) {
            in = new Scanner(soc.getInputStream());
            System.out.println("Client: " + in.nextLine());

            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            System.out.println("Enter message: ");
            String msg = sc.nextLine();
            if (msg.equals("STOP")) {
                break;
            } else {
                out.println(msg);
            }
        }

        serverSoc.close();
        sc.close();
    }
}
