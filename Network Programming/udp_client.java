import java.net.*;

public class udp_client {
    public static void main(String[] args) {
        try {

            DatagramSocket socket = new DatagramSocket();

            InetAddress inet = InetAddress.getByName("localhost");

            String message = "zerocool";

            DatagramPacket sendPacket = new DatagramPacket(
                    message.getBytes(),
                    message.length(),
                    inet,
                    8773
            );

            socket.send(sendPacket);

            System.out.println("Message sent: " + message);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
