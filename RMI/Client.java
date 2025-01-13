import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            ADD stub = (ADD) Naming.lookup("rmi://localhost:8773/suraj");
            System.out.println("Sum: " + stub.add(3, 2));
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
