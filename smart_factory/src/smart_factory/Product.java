package smart_factory;

public class Product {
    private String name;
    private boolean isComplete;
    private String location;

    public Product(String name) {
        this.name = name;
        this.isComplete = false;
        this.location = "Warehouse";
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
