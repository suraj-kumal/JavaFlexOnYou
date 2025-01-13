import java.net.*;

public class udp_server {
    public static void main(String[] args) {
        try {

            DatagramSocket socket = new DatagramSocket(8773);
            System.out.println("Server started, waiting for messages...");

            while (true) {
                byte[] receiveData = new byte[100]; // Allocate buffer to receive data
                DatagramPacket receivedPacket = new DatagramPacket(receiveData, receiveData.length);

                socket.receive(receivedPacket);

                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Received message: " + message);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in server: " + e.getMessage());
        }
    }
}
