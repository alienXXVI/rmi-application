   
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class ServerCalc  implements Calc {
        
    public ServerCalc() throws java.rmi.RemoteException {}

   
    
    public long add(long a, long b) 
    	    throws java.rmi.RemoteException { 
    	    System.out.println ("Adding " + a + " and " + b);
    	    return a + b; 
    	} 

    	public long sub(long a, long b) 
    	    throws java.rmi.RemoteException { 
    	    System.out.println ("Subtracting " + b + " from " + a);
    	    return a - b; 
    	} 

    	public long mul(long a, long b) 
    	    throws java.rmi.RemoteException { 
    	    System.out.println ("Multiplying " + a + " by " + b);
    	    return a * b; 
    	} 

    	public long div(long a, long b) 
    	    throws java.rmi.RemoteException { 
    	    System.out.println ("Dividing " + a + " by " + b);
    	    return a / b; 
    	} 
        
    public static void main(String args[]) {
        
        try {
            ServerCalc obj = new ServerCalc();
            Calc stub = (Calc) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            System.setProperty("java.rmi.server.hostname", "179.106.195.237");
            Registry registry = LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://179.106.195.237:2001/Calc", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
