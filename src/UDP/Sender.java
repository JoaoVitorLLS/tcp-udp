package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Correct usage: <machine name> <port> <message>");
            System.exit(0);
        }
        try {
            InetAddress address = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            byte[] message = args[2].getBytes();
            DatagramPacket packet = new DatagramPacket(message,message.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            System.out.println("Message sent to: " + address.getHostAddress() + "\n" +
                "Port: " + port + "\n" + "Message: " + args[2]);
            socket.close();
        }
        catch(IOException ioException) {
        }
    }
}
