import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculator {

    public Server() {
    }

    public Double sum(Double x, Double y) {
        return x + y;
    }

    public Double subtract(Double x, Double y) {
        return x - y;
    }

    public Double multiply(Double x, Double y) {
        return x * y;
    }

    public Double divide(Double x, Double y) {
        return x / y;
    }

    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            // Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(1888);
            registry.bind("Calculator", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}