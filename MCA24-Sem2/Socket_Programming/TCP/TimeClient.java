package TCP;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
    public static void main(String[] args) throws Exception {

        Socket soc = new Socket(InetAddress.getLocalHost(), 2000);
        System.out.println("Client Started and waiting ...");

        // get server data
        Scanner in = new Scanner(soc.getInputStream());
        System.out.println(in.nextLine());

    }
}
