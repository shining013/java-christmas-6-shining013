package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.Constants;
public class InputController {
    public static int setDate() {
        try {
            VisitDateValidator visitDateValidator = new VisitDateValidator(InputView.visitDateInput());
            int date = Integer.parseInt(visitDateValidator.getVisitDate());
            VisitDate visitDate = new VisitDate(date);
            return visitDate.getDate();
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.INVALID_DATE_ERROR);
            return setDate();
        }
    }

    public static String setOrder() {
        try {
            OrderValidator orderValidator = new OrderValidator(InputView.orderInput());
            return orderValidator.getString();
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.INVALID_ORDER_ERROR);
            return setOrder();
        }
    }
}

