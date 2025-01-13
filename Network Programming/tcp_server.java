import java.io.*;
import java.net.*;

public class tcp_server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8773);
            System.out.println("Server started, waiting for client...");

            Socket client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message from client: " + message);

            out.writeUTF("HELLO FROM SERVER");

            // Close the streams and the sockets
            in.close();
            out.close();
            client.close();
            server.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in server: " + e.getMessage());
        }
    }
}
