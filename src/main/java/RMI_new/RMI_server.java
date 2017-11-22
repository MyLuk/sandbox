package RMI_new;

import sun.management.jmxremote.ConnectorBootstrap;

import javax.management.remote.JMXConnectorServer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class RMI_server {

    public static void main(String[] args) {
        MyRemoteInterface myRemoteObject = new MyRemoteObject();
        try {
            MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(myRemoteObject, 0);
            Registry registry = LocateRegistry.createRegistry(1100);

            registry.bind("MyRemoteObject", stub);
            System.out.println("Bound MyRemoteObject");

        } catch (Throwable cause) {
            cause.printStackTrace();
        }

    }

}

interface MyRemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}

class MyRemoteObject implements MyRemoteInterface {
    @Override
    public String sayHello() throws RemoteException {
        return "Hello Bender";
    }
}