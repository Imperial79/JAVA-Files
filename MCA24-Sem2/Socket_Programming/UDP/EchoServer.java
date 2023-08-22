package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoServer {
    public static void main(String[] args) throws Exception {

        // 1. Create connection socket
        DatagramSocket ds = new DatagramSocket(2000);

        // 2. Recieve data from client and store in byte array and print
        byte inData[] = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(inData, inData.length);
        ds.receive(dp1);
        String str = new String(dp1.getData());
        System.out.println(str);

        // 3. Reply to client
        InetAddress ia = InetAddress.getLocalHost();
        int port = dp1.getPort(); // sender's port
        byte outData[] = ("Hello client").getBytes();
        DatagramPacket dp2 = new DatagramPacket(outData, outData.length, ia, port);
        ds.send(dp2);

        ds.close();

    }
}
