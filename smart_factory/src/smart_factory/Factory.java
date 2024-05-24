package smart_factory;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<FactoryComponent> components;

    public Factory() {
        components = new ArrayList<>();
    }

    public void addComponent(FactoryComponent component) {
        components.add(component);
    }

    public List<FactoryComponent> getComponents() {
        return components;
    }

    public List<Sensor> getSensors() {
        List<Sensor> sensors = new ArrayList<>();
        for (FactoryComponent component : components) {
            if (component instanceof Sensor) {
                sensors.add((Sensor) component);
            }
        }
        return sensors;
    }
}
