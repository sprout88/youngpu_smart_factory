package smart_factory;

import java.util.Random;

public class AGV extends FactoryComponent {
    private int id;
    private Random random = new Random();

    public AGV(int id) {
        this.id = id;
    }

    @Override
    public void start() {
        System.out.println("AGV " + id + " started.");
    }

    @Override
    public void stop() {
        System.out.println("AGV " + id + " stopped.");
    }

    public void moveProduct(Product product) {
        if (random.nextDouble() < 0.5) {
            product.setLocation("Machine Front");
            System.out.println("AGV " + id + " moved product " + product.getName() + " to Machine Front.");
        } else {
            product.setLocation("Elsewhere");
            System.out.println("AGV " + id + " moved product " + product.getName() + " to Elsewhere.");
        }
    }
}
