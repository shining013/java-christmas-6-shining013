package christmas.controller;

import java.util.HashMap;
import java.util.Map;

import christmas.model.*;
import christmas.view.OutputView;

public class EventController {
    private int visitDate;
    private Map<String, Integer> getOrder = new HashMap<>();
    private Order order;

    public EventController() {
        set();
        show();
    }

    public void set() {
        OutputView.Greeting();
        visitDate = InputController.setDate();
        String orderInput = InputController.setOrder();
        this.order = new Order(orderInput);
        getOrder = order.getMenu();
    }
    public void show() {
        OutputView.printPreview(visitDate);
        OutputView.printOrderMenu(getOrder);
        OutputView.printBeforeDiscountAmount(order.getBeforeDiscountAmount());
        OutputView.printGiftMenu(order.getBeforeDiscountAmount());
        Discount discount = new Discount(order.getBeforeDiscountAmount(),visitDate,getOrder);
        OutputView.printBenefitHistory(discount.getChristmasDayDiscountAmount(),discount.getWeekDayDiscountAmount(),discount.getWeekEndDiscountAmount(),discount.getSpecialDayAmount(),discount.getGiftAmount());
        double totalBenefitAmount = order.getTotalBenefitAmount(discount.getChristmasDayDiscountAmount(), discount.getWeekDayDiscountAmount(), discount.getWeekEndDiscountAmount(), discount.getSpecialDayAmount(), discount.getGiftAmount());
        OutputView.printTotalBenefit(order.getTotalBenefitAmount(discount.getChristmasDayDiscountAmount(), discount.getWeekDayDiscountAmount(), discount.getWeekEndDiscountAmount(), discount.getSpecialDayAmount(), discount.getGiftAmount()));
        double afterDiscountAmount = order.getBeforeDiscountAmount() - (totalBenefitAmount - discount.getGiftAmount());
        OutputView.printAfterDiscount(order.getBeforeDiscountAmount() - (totalBenefitAmount - discount.getGiftAmount()));
        BadgeUser badgeUser = new BadgeUser();
        OutputView.printEventBadge(badgeUser.calculateBadge(totalBenefitAmount));
    }
}