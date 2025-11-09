package abstract_farctory.factory_method;

import abstract_farctory.BaseMenuItem;

public class VegMenuFactory implements MenuItemFactory  {
    @Override
    public BaseMenuItem createMenuItem(String type) {
      
        switch (type.toLowerCase()) {
            case "italian pizza":
                return new BaseMenuItem("Italian Pizza", 10.0) {};
            case "eastern pizza":
                return new BaseMenuItem("Eastern Pizza", 12.0) {};
            case "classic burger":
                return new BaseMenuItem("Classic Burger", 8.0) {};
            default:
                throw new IllegalArgumentException("Unknown Veg menu item: " + type);
        }
    }
    }
