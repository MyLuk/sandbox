package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    @Override
    public String sayHello() throws RemoteException {
        return "Сервер говорит привет";
    }

    public MyRemoteImpl() throws RemoteException {}

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Remote Hello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
