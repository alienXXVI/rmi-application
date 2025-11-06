import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServerConverter implements Converter {

    // --- Temperatura ---
    public double celsiusToFahrenheit(double c) throws RemoteException {
        System.out.println("[LOG] Converting " + c + " °C to Fahrenheit");
        return (c * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double f) throws RemoteException {
        System.out.println("[LOG] Converting " + f + " °F to Celsius");
        return (f - 32) * 5/9;
    }

    // --- Distância ---
    public double kmToMiles(double km) throws RemoteException {
        System.out.println("[LOG] Converting " + km + " km to miles");
        return km * 0.621371;
    }

    public double milesToKm(double miles) throws RemoteException {
        System.out.println("[LOG] Converting " + miles + " miles to km");
        return miles / 0.621371;
    }

    public double metersToCentimeters(double meters) throws RemoteException {
        System.out.println("[LOG] Converting " + meters + " m to cm");
        return meters * 100;
    }

    public double centimetersToMeters(double cm) throws RemoteException {
        System.out.println("[LOG] Converting " + cm + " cm to m");
        return cm / 100;
    }

    // --- Peso ---
    public double kgToLbs(double kg) throws RemoteException {
        System.out.println("[LOG] Converting " + kg + " kg to lbs");
        return kg * 2.20462;
    }

    public double lbsToKg(double lbs) throws RemoteException {
        System.out.println("[LOG] Converting " + lbs + " lbs to kg");
        return lbs / 2.20462;
    }

    // --- Tempo ---
    public double hoursToMinutes(double hours) throws RemoteException {
        System.out.println("[LOG] Converting " + hours + " h to min");
        return hours * 60;
    }

    public double minutesToHours(double minutes) throws RemoteException {
        System.out.println("[LOG] Converting " + minutes + " min to h");
        return minutes / 60;
    }

    public static void main(String[] args) {
        try {
            ServerConverter obj = new ServerConverter();
            Converter stub = (Converter) UnicastRemoteObject.exportObject(obj, 0);

            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001/Converter", stub);

            System.out.println("Servidor pronto e aguardando conexoes...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
