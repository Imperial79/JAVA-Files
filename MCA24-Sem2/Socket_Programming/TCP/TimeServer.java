package TCP;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSoc = new ServerSocket(2000);
        System.out.println("Server Started ...");
        Socket soc = serverSoc.accept();

        System.out.println("Connected to " + soc.getInetAddress() + " on PORT: " + soc.getLocalPort());

        // Send data to client
        PrintWriter out = new PrintWriter(soc.getOutputStream());
        out.println("Server Date: " + (new Date()).toString());

        out.close();
        soc.close();
        serverSoc.close();

    }
}
