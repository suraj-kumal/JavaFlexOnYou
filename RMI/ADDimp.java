import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ADDimp extends UnicastRemoteObject implements ADD {

    public ADDimp() throws RemoteException {
        super();
    }

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}
