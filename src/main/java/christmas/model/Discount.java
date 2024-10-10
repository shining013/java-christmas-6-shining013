package christmas.model;

import java.util.HashMap;
import java.util.Map;

import christmas.Constants;

public class Discount {
    private final double beforeDiscountAmount;
    private final int visitDate;
    private double christmasDayDiscountAmount = 0;
    private double weekDayDiscountAmount = 0;
    private double weekEndDiscountAmount = 0;
    private double specialDayAmount = 0;
    private double giftAmount = 0;
    private Map<String, Integer> getOrder = new HashMap<>();
    private MenuBoard menuBoard =  new MenuBoard();
    private Calendar calendar = new Calendar();

    public Discount(double beforeDiscountAmount, int visitDate, Map<String, Integer> order) {
        this.beforeDiscountAmount = beforeDiscountAmount;
        this.visitDate = visitDate;
        this.getOrder = order;
        eventApply();
    }

    public void eventApply() {
        if (beforeDiscountAmount < 10000) {
            System.out.println(Constants.EVENT_DO_NOT_APPLY);
            return;
        }
        applyDiscount();
    }

    public void applyDiscount() {
        christmasDayDiscountAmount = calendar.christmasDiscountApply(visitDate);
        specialDayAmount = calendar.specialDiscountApply(visitDate);
        this.giftAmount = calendar.giftApply(beforeDiscountAmount);
        if (calendar.weekDayApply(visitDate)) {
            calculateWeekDayDiscount();
        }
        if (!calendar.weekDayApply(visitDate)) {
            calculateWeekEndDiscount();
        }
    }

    public void calculateWeekDayDiscount() {
        for (String key : getOrder.keySet()) {
            weekDayDiscountAmount += menuBoard.calculateDessertAmount(key, getOrder.get(key));
        }
    }

    public void calculateWeekEndDiscount() {
        for (String key : getOrder.keySet()) {
            weekEndDiscountAmount += menuBoard.calculateMainDish(key, getOrder.get(key));
        }
    }

    public double getChristmasDayDiscountAmount() {
        return christmasDayDiscountAmount;
    }

    public double getWeekDayDiscountAmount() {
        return weekDayDiscountAmount;
    }

    public double getWeekEndDiscountAmount() {
        return weekEndDiscountAmount;
    }

    public double getSpecialDayAmount() {
        return specialDayAmount;
    }

    public double getGiftAmount() {
        return giftAmount;
    }
}
