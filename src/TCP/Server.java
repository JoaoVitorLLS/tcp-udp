package TCP;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("The server is listening to the following port: 12345");
            while(true) {
                Socket client = server.accept();
                System.out.println("The client is connected: " + client.getInetAddress().getHostAddress());
                ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
                output.flush();
                output.writeObject(new Date());
                output.close();
                client.close();
            }
        }
        catch(Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
