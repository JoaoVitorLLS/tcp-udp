package TCP;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 12345);
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            Date currentDate = (Date)input.readObject();
            JOptionPane.showMessageDialog(null,"Date received from the server: " + currentDate.toString());
            input.close();
            System.out.println("Conection closed.");
        }
        catch(Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
