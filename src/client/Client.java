import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private static Scanner sc = new Scanner(System.in, "UTF-8");

    private Client() {
    }

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1888);
            Calculator stub = (Calculator) registry.lookup("Calculator");

            Double A, B;
            String res;
            System.out.println("===========================");
            System.out.println("ESCOLHA A OPERAÇÃO :\n1) Soma\n2) Subtracao\n3) Multiplicacao\n4) Divisao");
            int resp = sc.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("Soma de A + B\nValor de A:");
                    A = sc.nextDouble();
                    System.out.println("Valor de B:");
                    B = sc.nextDouble();

                    res = stub.sum(A, B).toString();
                    System.out.println("Resultado da soma: " + res);
                    break;
                case 2:
                    System.out.println("Subtracao de A - B\nValor de A:");
                    A = sc.nextDouble();
                    System.out.println("Valor de B:");
                    B = sc.nextDouble();

                    res = stub.subtract(A, B).toString();
                    System.out.println("Resultado da subtracao: " + res);
                    break;

                case 3:
                    System.out.println("Multiplicacao de A * B\n Valor de A:");
                    A = sc.nextDouble();
                    System.out.println("Valor de B:");
                    B = sc.nextDouble();

                    res = stub.multiply(A, B).toString();
                    System.out.println("Resultado da multiplicacao: " + res);
                    break;

                case 4:
                    System.out.println("Divisao de A / B\n Valor de A:");
                    A = sc.nextDouble();
                    System.out.println("Valor de B:");
                    B = sc.nextDouble();

                    res = stub.divide(A, B).toString();
                    System.out.println("Resultado: " + res);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

            main(args);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        sc.close();
    }
}