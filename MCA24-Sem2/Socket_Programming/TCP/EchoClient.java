package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {

        System.out.println("Client Started ... ");

        // 1. connection with server ------------------->
        Socket soc = new Socket("127.0.0.1", 1000);
        System.out.println(soc.getInetAddress() + " connected to port " + soc.getPort());

        // 2. Create Message for server -------------->
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String str = sc.nextLine();

        // 3. Sending the message to server ---------->

        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        out.println(str);

        // 4. Read the response from server ---------------->
        Scanner in = new Scanner(soc.getInputStream());
        System.out.println(in.nextLine());

        in.close();
        soc.close();
        sc.close();

    }
}
