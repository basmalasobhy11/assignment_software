package abstract_farctory.factory_method;
import abstract_farctory.BaseMenuItem;
public class MenuClient {
    public static void main(String[] args) {
        MenuItemFactory vegFactory = new VegMenuFactory();
        MenuItemFactory nonVegFactory = new NoVegMenuFactory();

        BaseMenuItem item1 = vegFactory.createMenuItem("Italian Pizza");
        BaseMenuItem item2 = nonVegFactory.createMenuItem("chicken shawarma");

        System.out.println(item1.getName() + " - $" + item1.getPrice());
        System.out.println(item2.getName() + " - $" + item2.getPrice());
    }
}
