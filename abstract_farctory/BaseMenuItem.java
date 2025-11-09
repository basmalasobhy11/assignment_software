package abstract_farctory;
public abstract class BaseMenuItem implements menuItem {
    private String name;
    private double price;

    public BaseMenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
