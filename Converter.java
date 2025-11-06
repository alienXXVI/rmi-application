import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Converter extends Remote {
    double celsiusToFahrenheit(double celsius) throws RemoteException;

    double fahrenheitToCelsius(double fahrenheit) throws RemoteException;

    double kmToMiles(double km) throws RemoteException;
    
    double milesToKm(double miles) throws RemoteException;
}
