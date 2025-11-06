import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientConverter {

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];

        try {
            Registry registry = LocateRegistry.getRegistry(host, 2001);
            Converter stub = (Converter) registry.lookup("Converter");

            Scanner sc = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n=== CONVERSOR DE MEDIDAS ===");
                System.out.println("1 - Celsius -> Fahrenheit");
                System.out.println("2 - Fahrenheit -> Celsius");
                System.out.println("3 - Km -> Milhas");
                System.out.println("4 - Milhas -> Km");
                System.out.println("5 - Metros -> Centimetros");
                System.out.println("6 - Centimetros -> Metros");
                System.out.println("7 - Quilogramas -> Libras");
                System.out.println("8 - Libras -> Quilogramas");
                System.out.println("9 - Horas -> Minutos");
                System.out.println("10 - Minutos -> Horas");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opcao: ");
                opcao = sc.nextInt();

                if (opcao == 0) break;

                System.out.print("Digite o valor a converter: ");
                double valor = sc.nextDouble();

                double resultado;

                switch (opcao) {
                    case 1 -> {
                        resultado = stub.celsiusToFahrenheit(valor);
                        System.out.printf("%.2f °C = %.2f °F%n", valor, resultado);
                    }
                    case 2 -> {
                        resultado = stub.fahrenheitToCelsius(valor);
                        System.out.printf("%.2f °F = %.2f °C%n", valor, resultado);
                    }
                    case 3 -> {
                        resultado = stub.kmToMiles(valor);
                        System.out.printf("%.2f km = %.2f milhas%n", valor, resultado);
                    }
                    case 4 -> {
                        resultado = stub.milesToKm(valor);
                        System.out.printf("%.2f milhas = %.2f km%n", valor, resultado);
                    }
                    case 5 -> {
                        resultado = stub.metersToCentimeters(valor);
                        System.out.printf("%.2f m = %.2f cm%n", valor, resultado);
                    }
                    case 6 -> {
                        resultado = stub.centimetersToMeters(valor);
                        System.out.printf("%.2f cm = %.2f m%n", valor, resultado);
                    }
                    case 7 -> {
                        resultado = stub.kgToLbs(valor);
                        System.out.printf("%.2f kg = %.2f lbs%n", valor, resultado);
                    }
                    case 8 -> {
                        resultado = stub.lbsToKg(valor);
                        System.out.printf("%.2f lbs = %.2f kg%n", valor, resultado);
                    }
                    case 9 -> {
                        resultado = stub.hoursToMinutes(valor);
                        System.out.printf("%.2f h = %.2f min%n", valor, resultado);
                    }
                    case 10 -> {
                        resultado = stub.minutesToHours(valor);
                        System.out.printf("%.2f min = %.2f h%n", valor, resultado);
                    }
                    default -> System.out.println("Opcao invalida!");
                }

            } while (opcao != 0);

            System.out.println("Encerrando o cliente...");
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
