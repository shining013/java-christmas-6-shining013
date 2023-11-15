package christmas.model;

public class MenuItem {
    private final String name;
    private final String category;
    private final double price;

    public MenuItem(String menuName, double menuPrice, String category) {
        this.name = menuName;
        this.price = menuPrice;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
