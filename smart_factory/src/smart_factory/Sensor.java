package smart_factory;
import java.util.Random;

public class Sensor extends FactoryComponent {
    private int value;
    private int dangerThreshold;
    private int id;

    public Sensor(int id, int dangerThreshold) {
        this.id = id;
        this.dangerThreshold = dangerThreshold;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDangerThreshold() {
        return dangerThreshold;
    }

    public boolean isDangerous() {
        return value > dangerThreshold;
    }

    public int getId() {
        return id;
    }

    @Override
    public void start() {
        System.out.println("Sensor " + id + " started.");
    }

    @Override
    public void stop() {
        System.out.println("Sensor " + id + " stopped.");
    }

    public void testProduct(Product product) {
        Random random = new Random();
        boolean complete = random.nextDouble() < 0.5;
        product.setComplete(complete);
        if (complete) {
            System.out.println("Sensor " + id + " marked product " + product.getName() + " as complete.");
        } else {
            System.out.println("Sensor " + id + " marked product " + product.getName() + " as incomplete.");
        }
    }
}
