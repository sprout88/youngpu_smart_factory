package smart_factory;

import java.util.List;
import java.util.Random;

public class ProductionMachine extends FactoryComponent {
    private boolean operational = true;
    private String status;
    private int id;

    public ProductionMachine(int id) {
        this.id = id;
    }

    @Override
    public void start() {
        System.out.println("Production Machine " + id + " ready to start.");
    }

    @Override
    public void stop() {
        System.out.println("Production Machine " + id + " stopped.");
    }

    public boolean start(List<Sensor> sensors, Product product) {
        if (operational && "Machine Front".equals(product.getLocation())) {
            status = "Running";
            System.out.println("Production machine " + id + " started.");
            for (Sensor sensor : sensors) {
                sensor.testProduct(product);
                if (sensor.isDangerous()) {
                    status = "Stopped";
                    System.out.println("Sensor " + sensor.getId() + " detected danger. Stopping production machine " + id + ".");
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("Production machine " + id + " cannot start as it is not operational or product is not in the correct location.");
            return false;
        }
    }

    public boolean isOperational() {
        return operational;
    }
}
