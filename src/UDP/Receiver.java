package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;

public class Receiver {
    public static void main(String[] args) {
        if(args.length != 1) {
          System.out.println("Choose a port:");
          System.exit(0);
        }
        try {
            int port = Integer.parseInt(args[0]);
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Listening to the folowing port: " + port);
            byte[] message = new byte[256];
            DatagramPacket packet = new DatagramPacket(message, message.length);
            socket.receive(packet);
            JOptionPane.showMessageDialog(null, new String(packet.getData()).trim(), "Message received!", 1);
            socket.close();
        }
        catch(IOException ioException) {
        }
    }
}
