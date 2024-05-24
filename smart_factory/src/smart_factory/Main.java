package smart_factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        ProductionMachine machine1 = new ProductionMachine(1);
        Sensor sensor1 = new Sensor(1, 5);
        Sensor sensor2 = new Sensor(2, 5);
        AGV agv1 = new AGV(1);

        factory.addComponent(machine1);
        factory.addComponent(sensor1);
        factory.addComponent(sensor2);
        factory.addComponent(agv1);

        AutomatedSystem system = new AutomatedSystem(factory);

        Product product = new Product("Widget");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Start Production");
            System.out.println("2. Stop Production");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.startProduction(product);
                    break;
                case 2:
                    system.stopProduction();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
