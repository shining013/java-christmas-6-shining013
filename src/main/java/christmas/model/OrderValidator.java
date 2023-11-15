package christmas.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import christmas.Constants;

public class OrderValidator {
    private final Map<String, Integer> ITEMS = new HashMap<>();
    private final String ENTER_ORDER;
    private final MenuBoard menuBoard = new MenuBoard();

    public OrderValidator(String enterOrder) {
        this.ENTER_ORDER = enterOrder;
        setToOrder(this.ENTER_ORDER);
        validate();
    }

    public String getString() {
        return ENTER_ORDER;
    }

    public void addItem(String menu, int quantity) {
        if (ITEMS.containsKey(menu)) {
            throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
        }
        ITEMS.put(menu, quantity);
    }

    public void setToOrder(String enterOrder) {
        String[] orders = enterOrder.split(Constants.DELIMITER);
        for (String orderStr : orders) {
            String[] orderParts = orderStr.split(Constants.DASH);
            if (orderParts.length == 2) {
                String menu = orderParts[0];
                int quantity = Integer.parseInt(orderParts[1]);
                addItem(menu, quantity);
            }
        }
    }

    public void validate() {
        isValidOrderType();
        isMenuExist();
        isQuantityMoreThanOne();
        isTotalQuantityExceed20();
        isOrderIsAllBeverage();
    }

    public void isValidOrderType() {
        Matcher matcher = Constants.ORDER_PATTERN.matcher(ENTER_ORDER);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
        }
    }

    public void isMenuExist() {
        for (Map.Entry<String, Integer> entry : ITEMS.entrySet()) {
            String menuName = entry.getKey();
            MenuItem foundMenu = menuBoard.findMenuByName(menuName);
            if (foundMenu == null) {
                throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
            }
        }
    }

    public void isQuantityMoreThanOne() {
        for (Map.Entry<String, Integer> entry : ITEMS.entrySet()) {
            int quantity = entry.getValue();
            if (quantity < 1) {
                throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
            }
        }
    }

    public void isTotalQuantityExceed20() {
        int totalQuantity = 0;
        for (Map.Entry<String, Integer> entry : ITEMS.entrySet()) {
            int quantity = entry.getValue();
            if (totalQuantity + quantity > 20) {
                throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
            }
            totalQuantity += quantity;
        }
    }

    public void isOrderIsAllBeverage() {
        boolean allBeverages = true;
        for (String menu : ITEMS.keySet()) {
            MenuItem menuItem = menuBoard.findMenuByName(menu);
            if (!menuItem.getCategory().equalsIgnoreCase("beverage")) {
                allBeverages = false;
                break;
            }
        }
        if (allBeverages) {
            throw new IllegalArgumentException(Constants.INVALID_ORDER_ERROR);
        }
    }

    @Override
    public String toString() {
        return String.format("주문 메뉴 (주문 메뉴 : %s", ENTER_ORDER);
    }
}