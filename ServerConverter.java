import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class ServerConverter implements Converter {

    public double celsiusToFahrenheit(double c) throws RemoteException {
        System.out.println("Converting " + c + " °C to Fahrenheit");
        return (c * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double f) throws RemoteException {
        System.out.println("Converting " + f + " °F to Celsius");
        return (f - 32) * 5/9;
    }

    public double kmToMiles(double km) throws RemoteException {
        System.out.println("Converting " + km + " km to miles");
        return km * 0.621371;
    }

    public double milesToKm(double miles) throws RemoteException {
        System.out.println("Converting " + miles + " miles to km");
        return miles / 0.621371;
    }

    public static void main(String[] args) {
        try {
            ServerConverter obj = new ServerConverter();
            Converter stub = (Converter) UnicastRemoteObject.exportObject(obj, 0);

            System.setProperty("java.rmi.server.hostname", "179.106.195.237");
            Registry registry = LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://179.106.195.237:2001/Converter", stub);

            System.out.println("Converter Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
