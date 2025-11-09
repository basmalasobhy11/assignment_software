package abstract_farctory.factory_method;

import abstract_farctory.BaseMenuItem;

public class NoVegMenuFactory implements MenuItemFactory  {
    @Override
    public BaseMenuItem createMenuItem(String type) {
        switch (type.toLowerCase()) {
            case "chicken pizza":
                return new BaseMenuItem("chicken pizza", 12.0) {};
           case "chicken shawarma":
                return new BaseMenuItem("chicken shawarma", 12.0) {};
            default:
                throw new IllegalArgumentException("Unknown Veg menu item: " + type);
        }
    }
    }
