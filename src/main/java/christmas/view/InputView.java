package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import christmas.Constants;

public class InputView {
    public static String visitDateInput() {
        System.out.println(Constants.ENTER_VISIT_DATE);
        return Console.readLine();
    }

    public static String orderInput() {
        System.out.println(Constants.ENTER_MENU);
        return Console.readLine();
    }
}