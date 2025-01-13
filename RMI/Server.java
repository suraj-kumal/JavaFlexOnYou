import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(8773);
            ADD stub = new ADDimp();
            registry.rebind("suraj", stub);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
