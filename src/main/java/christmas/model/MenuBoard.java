package christmas.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MenuBoard {
    private final ArrayList<MenuItem> menuList;

    public MenuBoard() {
        this.menuList = new ArrayList<>();
        initializeMenu();
    }

    public void initializeMenu() {
        MenuItem[] menu = {
            new MenuItem("양송이수프", 6000, "appetizer"),
            new MenuItem("타파스", 5500, "appetizer"),
            new MenuItem("시저샐러드", 8000, "appetizer"),
            new MenuItem("티본스테이크", 55000, "mainDish"),
            new MenuItem("바비큐립", 54000, "mainDish"),
            new MenuItem("해산물파스타", 35000, "mainDish"),
            new MenuItem("크리스마스파스타", 25000, "mainDish"),
            new MenuItem("초코케이크", 15000, "dessert"),
            new MenuItem("아이스크림", 5000, "dessert"),
            new MenuItem("제로콜라", 3000, "beverage"),
            new MenuItem("레드와인", 60000, "beverage"),
            new MenuItem("샴페인", 25000, "beverage")
        };
        Collections.addAll(menuList, menu);
    }

    public MenuItem findMenuByName(String menuName) {
        for (MenuItem menuItem : menuList) {
            if (menuItem.getName().equalsIgnoreCase(menuName)) {
                return menuItem;
            }
        }
        return null;
    }

    public double getMenuPrice(String menuName) {
        for (MenuItem menuItem : menuList) {
            if (Objects.equals(menuItem.getName(),menuName)) {
                return menuItem.getPrice();
            }
        }
        return 0;
    }

    public double calculateDessertAmount(String menuName, int quantity) {
        for (MenuItem menuItem : menuList) {
            if ((Objects.equals(menuItem.getName(), menuName) && (Objects.equals(menuItem.getCategory(), "dessert")))) {
                return 2023 * quantity;
            }
        }
        return 0;
    }

    public double calculateMainDish(String menuName, int quantity) {
        for (MenuItem menuItem : menuList) {
            if (Objects.equals(menuItem.getName(), menuName) && Objects.equals(menuItem.getCategory(), "mainDish")) {
                return 2023 * quantity;
            }
        }
        return 0;
    }
}
