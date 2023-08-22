package TCP;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws Exception {

        System.out.println("Waiting...");

        // 1. Create connection point for clients and accept --------->
        ServerSocket serverSoc = new ServerSocket(1000);
        Socket soc = serverSoc.accept();
        System.out
                .println("Connection established ... " + soc.getInetAddress() + " on port " + serverSoc.getLocalPort());

        // 2. Recieve message from Client --------->
        Scanner in = new Scanner(soc.getInputStream());
        String str = in.nextLine();

        // 3. Reply to the message ----------->

        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
        out.println("Server: " + str);

        soc.close();
        serverSoc.close();

    }
}