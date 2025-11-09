package decorator;
import abstract_farctory.menuItem;
public class toppings extends AddOns {
    protected menuItem Item;
    public toppings(menuItem Item) {
        super(Item);
    }

    @Override
    public String getName() {
        return Item.getName() + " with toppings";
    }

    @Override
    public double getPrice() {
        return Item.getPrice() + 5.5;
    }
    
}