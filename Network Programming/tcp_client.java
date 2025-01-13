import java.io.*;
import java.net.*;

public class tcp_client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8773);

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            out.writeUTF("HELLO FROM CLIENT");

            String message = in.readUTF();
            System.out.println("Message from server: " + message);

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in client: " + e.getMessage());
        }
    }
}
