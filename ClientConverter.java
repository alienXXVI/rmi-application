import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientConverter {

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host, 2001);
            Converter stub = (Converter) registry.lookup("Converter");

            System.out.println("25 °C = " + stub.celsiusToFahrenheit(25) + " °F");
            System.out.println("100 °F = " + stub.fahrenheitToCelsius(100) + " °C");
            System.out.println("10 km = " + stub.kmToMiles(10) + " milhas");
            System.out.println("6.2 milhas = " + stub.milesToKm(6.2) + " km");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
