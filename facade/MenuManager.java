package facade;

import abstract_farctory.BaseMenuItem;
import abstract_farctory.factory_method.*;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private MenuItemFactory vegFactory = new VegMenuFactory();
    private MenuItemFactory noVegFactory = new NoVegMenuFactory();
    private MenuItemFactory kidsFactory = new KidsMenuFactory();

    public  void displayMenu(String category) {
        List<BaseMenuItem> menuItems = new ArrayList<>();

        switch (category.toLowerCase()) {
            case "veg":
                menuItems.add(vegFactory.createMenuItem("Italian pizza"));
                menuItems.add(vegFactory.createMenuItem("Eastern Pizza"));
                break;
            case "non-veg":
                menuItems.add(noVegFactory.createMenuItem("Chicken Pizza"));
                menuItems.add(noVegFactory.createMenuItem("Chicken Shawarma"));
                break;
            case "kids":
                menuItems.add(kidsFactory.createMenuItem("Kids Meal"));
                menuItems.add(kidsFactory.createMenuItem("Checkin nuggets"));
                menuItems.add(kidsFactory.createMenuItem("Mini burger"));
                break;
            default:
                System.out.println("Unknown menu category: " + category);
                return;
        }

        System.out.println("\n--- " + category.toUpperCase() + " MENU ---");
        for (BaseMenuItem item : menuItems) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
    }

    public BaseMenuItem createMenuItem(String category, String type) {
        switch (category.toLowerCase()) {
            case "veg":
                return vegFactory.createMenuItem(type);
            case "non-veg":
                return noVegFactory.createMenuItem(type);
            case "kids":
                return kidsFactory.createMenuItem(type);
            default:
                throw new IllegalArgumentException("Unknown menu category: " + category);
                
        }
    }}

