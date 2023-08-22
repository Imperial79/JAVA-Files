package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) throws Exception {

        InetAddress address;
        int port;

        DatagramSocket ds = new DatagramSocket(1234);

        System.out.println("Server is Online ..");

        byte inData[] = new byte[1024];

        DatagramPacket readDP = new DatagramPacket(inData, inData.length);

        ds.receive(readDP);

        port = readDP.getPort();
        address = readDP.getAddress();

        Date d = new Date();
        byte outData[] = d.toString().getBytes();

        DatagramPacket sendDP = new DatagramPacket(outData, outData.length, address, port);

        ds.send(sendDP);
        ds.close();

    }
}
