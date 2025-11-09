package abstract_farctory.factory_method;
import abstract_farctory.BaseMenuItem;

public interface MenuItemFactory {
    BaseMenuItem createMenuItem(String type);
}