import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Converter extends Remote {
    // Temperatura
    double celsiusToFahrenheit(double celsius) throws RemoteException;
    double fahrenheitToCelsius(double fahrenheit) throws RemoteException;

    // Distância
    double kmToMiles(double km) throws RemoteException;
    double milesToKm(double miles) throws RemoteException;
    double metersToCentimeters(double meters) throws RemoteException;
    double centimetersToMeters(double cm) throws RemoteException;

    // Peso
    double kgToLbs(double kg) throws RemoteException;
    double lbsToKg(double lbs) throws RemoteException;

    // Tempo
    double hoursToMinutes(double hours) throws RemoteException;
    double minutesToHours(double minutes) throws RemoteException;

    // Altura
    double metersToFeet(double meters) throws RemoteException;
    double feetToMeters(double feet) throws RemoteException;
}
