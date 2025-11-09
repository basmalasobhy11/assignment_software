package decorator;
import abstract_farctory.menuItem;
public class ExtraSause extends AddOns {
    protected menuItem Item;
    public ExtraSause(menuItem Item) {
        super(Item);
    }

    @Override
    public String getName() {
        return Item.getName() + " + Extra Sause";
    }

    @Override
    public double getPrice() {
        return Item.getPrice() + 3.5;
    }
    
}