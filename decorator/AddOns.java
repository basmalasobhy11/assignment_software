package decorator;
import abstract_farctory.menuItem;

public abstract class AddOns implements menuItem {
    protected menuItem Item;
    public AddOns(menuItem Item) {
         this.Item = Item; 
        }
}
