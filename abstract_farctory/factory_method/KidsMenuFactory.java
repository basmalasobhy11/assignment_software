package abstract_farctory.factory_method;
import abstract_farctory.BaseMenuItem;

public class KidsMenuFactory implements MenuItemFactory {
    @Override
    public BaseMenuItem createMenuItem(String type) {
        switch (type.toLowerCase()) {
            case "kids meal":
                return new BaseMenuItem("Kids Meal",7.99) {};
            case "mini burger":
                return new BaseMenuItem("Mini Burger",6.99) {};
            case "chicken nuggets":
                return new BaseMenuItem("Chicken Nuggets",12.99) {};
            default:
                throw new IllegalArgumentException("❌ Unknown kids menu item type: " + type);
        }
    }

}
