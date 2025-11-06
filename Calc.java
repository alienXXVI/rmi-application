import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote {
      
    public long add(long a, long b) throws java.rmi.RemoteException; 

    public long sub(long a, long b) throws java.rmi.RemoteException; 

   	public long mul(long a, long b) throws java.rmi.RemoteException; 

   	public long div(long a, long b) throws java.rmi.RemoteException; 
}
