import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServerConverter implements Converter {

    // --- Temperatura ---
    public double celsiusToFahrenheit(double c) throws RemoteException {
        System.out.println("Convertendo " + c + " °C para Fahrenheit");
        return (c * 9/5) + 32;
    }

    public double fahrenheitToCelsius(double f) throws RemoteException {
        System.out.println("Convertendo " + f + " °F para Celsius");
        return (f - 32) * 5/9;
    }

    // --- Distância ---
    public double kmToMiles(double km) throws RemoteException {
        System.out.println("Convertendo " + km + " km para miles");
        return km * 0.621371;
    }

    public double milesToKm(double miles) throws RemoteException {
        System.out.println("Convertendo " + miles + " miles para km");
        return miles / 0.621371;
    }

    public double metersToCentimeters(double meters) throws RemoteException {
        System.out.println("Convertendo " + meters + " m para cm");
        return meters * 100;
    }

    public double centimetersToMeters(double cm) throws RemoteException {
        System.out.println("Convertendo " + cm + " cm para m");
        return cm / 100;
    }

    // --- Peso ---
    public double kgToLbs(double kg) throws RemoteException {
        System.out.println("Convertendo " + kg + " kg para lbs");
        return kg * 2.20462;
    }

    public double lbsToKg(double lbs) throws RemoteException {
        System.out.println("Convertendo " + lbs + " lbs para kg");
        return lbs / 2.20462;
    }

    // --- Tempo ---
    public double hoursToMinutes(double hours) throws RemoteException {
        System.out.println("Convertendo " + hours + " h para min");
        return hours * 60;
    }

    public double minutesToHours(double minutes) throws RemoteException {
        System.out.println("Convertendo " + minutes + " min para h");
        return minutes / 60;
    }

	public double metersToFeet(double meters) throws RemoteException {
        System.out.println("Converting " + meters + " meters to feet");
        return meters * 3.28084;
    }

    public double feetToMeters(double feet) throws RemoteException {
        System.out.println("Converting " + feet + " feet to meters");
        return feet / 3.28084;
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
