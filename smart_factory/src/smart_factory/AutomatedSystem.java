package smart_factory;

import java.util.List;

public class AutomatedSystem {
    private Factory factory;

    public AutomatedSystem(Factory factory) {
        this.factory = factory;
    }

    public void startProduction(Product product) {
        System.out.println("Starting production in the factory...");
        boolean allComponentsOperational = true;
        for (FactoryComponent component : factory.getComponents()) {
            component.start();
            if (component instanceof ProductionMachine) {
                ProductionMachine machine = (ProductionMachine) component;
                if (!machine.isOperational()) {
                    allComponentsOperational = false;
                }
            }
        }
        if (!allComponentsOperational) {
            System.out.println("Not all components are operational. Cannot start production.");
            return;
        }

        moveProductToMachineFront(product);

        checkSensorsAndControlMachines(product);
        System.out.println("Production completed successfully.");
    }

    private void moveProductToMachineFront(Product product) {
        for (FactoryComponent component : factory.getComponents()) {
            if (component instanceof AGV) {
                ((AGV) component).moveProduct(product);
            }
        }
    }

    private void checkSensorsAndControlMachines(Product product) {
        List<Sensor> sensors = factory.getSensors();
        for (FactoryComponent component : factory.getComponents()) {
            if (component instanceof ProductionMachine) {
                ProductionMachine machine = (ProductionMachine) component;
                boolean machineRunning = machine.start(sensors, product);
                if (!machineRunning) {
                    System.out.println("Stopping all machines due to dangerous sensor readings.");
                    stopProduction();
                    return;
                }
            }
        }
    }

    public void stopProduction() {
        System.out.println("Stopping production in the factory...");
        for (FactoryComponent component : factory.getComponents()) {
            component.stop();
        }
    }
}
