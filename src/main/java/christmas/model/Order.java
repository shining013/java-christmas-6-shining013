package christmas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import christmas.Constants;

public class Order {
    public static Map<String, Integer> ITEMS;
    private final MenuBoard menuBoard = new MenuBoard();
    private double beforeDiscountAmount = 0;

    public Order(String enterOrder) {
        ITEMS = new HashMap<>();
        setOrder(enterOrder);
        setBeforeDiscountAmount();
    }

    public List<String> getOrderMenu() {
        return new ArrayList<>(ITEMS.keySet());
    }

    public Map<String, Integer> getMenu() {
        return ITEMS;
    }

    public void addItem(String menu, int quantity) {
        if (ITEMS.containsKey(menu)) {
            throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
        }
        ITEMS.put(menu, quantity);
    }

    public void setOrder(String enterOrder) {
        String[] orders = enterOrder.split(Constants.DELIMITER);
        for (String orderStr : orders) {
            String[] orderParts = orderStr.split(Constants.DASH);
            if (orderParts.length == 2) {
                setOrderBoard(orderParts);
            }
        }
    }

    public void setOrderBoard(String[] order) {
        String menu = order[0];
        int quantity = Integer.parseInt(order[1]);
        addItem(menu, quantity);
    }

    public void setBeforeDiscountAmount() {
        for (String str : getOrderMenu()) {
            double price = menuBoard.getMenuPrice(str);
            int quantity = getQuantity(str);
            beforeDiscountAmount += price * quantity;
        }
    }

    public double getBeforeDiscountAmount() {
        return beforeDiscountAmount;
    }

    public double getTotalBenefitAmount(double christmas, double weekDay, double weekEnd, double special, double gift) {
        return christmas + weekDay + weekEnd + special + gift;
    }

    public int getQuantity(String menu) {
        return ITEMS.get(menu);
    }
}