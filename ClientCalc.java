import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientCalc {

    private ClientCalc() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host, 2000);
            Calc stub = (Calc) registry.lookup("rmi://192.168.126.131:2000/Calc");
            System.out.println( stub.sub(4, 3) ); 
            System.out.println( stub.add(4, 5) ); 
            System.out.println( stub.mul(3, 6) ); 
            System.out.println( stub.div(9, 3) ); 
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
