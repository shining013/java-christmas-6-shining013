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

    @Override
    public String toString() {
        return String.format("메뉴 항목 (메뉴명 : %s, 카테고리 : %s, 가격 : %f)",name,category,price);
    }
}
