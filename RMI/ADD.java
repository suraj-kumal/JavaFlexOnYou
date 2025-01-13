import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ADD extends Remote {
    int add(int x, int y) throws RemoteException;
}
