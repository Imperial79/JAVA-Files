package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        // 1. Connection
        DatagramSocket ds = new DatagramSocket();

        // 2. create message for server
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message for server: ");
        byte outData[] = (sc.nextLine()).getBytes();

        // 3. send message on specific port and address
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(outData, outData.length, ia, 2000);
        ds.send(dp);

        // 4. Recieve message from server
        byte inData[] = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(inData, inData.length);
        ds.receive(dp2);
        String str = new String(dp2.getData());
        System.out.println("Server: " + str);

        ds.close();
        sc.close();

    }
}
