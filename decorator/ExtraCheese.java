package decorator;
import abstract_farctory.menuItem;
public class ExtraCheese extends AddOns {
    
    public ExtraCheese(menuItem Item) {
        super(Item);
    }

    @Override
    public String getName() {
        return Item.getName() + " + Extra Cheese";
    }

    @Override
    public double getPrice() {
        return Item.getPrice() + 1.5;
    }
    
}
