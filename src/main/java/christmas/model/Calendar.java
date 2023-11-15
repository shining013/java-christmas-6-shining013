package christmas.model;

import java.util.ArrayList;
import java.util.Collections;

public class Calendar {
    private final ArrayList<Date> calendar;

    public Calendar() {
        this.calendar = new ArrayList<>();
        Date[] dates = {
                new Date(1, true, false, false),
                new Date(2, true, false, false),
                new Date(3, true, true, true),
                new Date(4, true, false, true),
                new Date(5, true, false, true),
                new Date(6, true, false, true),
                new Date(7, true, false, true),
                new Date(8, true, false, false),
                new Date(9, true, false, false),
                new Date(10, true, true, true),
                new Date(11, true, false, true),
                new Date(12, true, false, true),
                new Date(13, true, false, true),
                new Date(14, true, false, true),
                new Date(15, true, false, false),
                new Date(16, true, false, false),
                new Date(17, true, true, true),
                new Date(18, true, false, true),
                new Date(19, true, false, true),
                new Date(20, true, false, true),
                new Date(21, true, false, true),
                new Date(22, true, false, false),
                new Date(23, true, false, false),
                new Date(24, true, true, true),
                new Date(25, true, true, true),
                new Date(26, false, false, true),
                new Date(27, false, false, true),
                new Date(28, false, false, true),
                new Date(29, false, false, false),
                new Date(30, false, false, false),
                new Date(31, false, true, true)
        };
        Collections.addAll(calendar, dates);
    }

    public double christmasDiscountApply(int targetDay) {
        for (Date date : calendar) {
            if (date.getDate() == targetDay && date.isChristmasD_dayDiscount()) {
                return 1000 + ((targetDay - 1) * 100);
            }
        }
        return 0;
    }

    public double specialDiscountApply(int targetDay) {
        for (Date date : calendar) {
            if (date.getDate() == targetDay && date.isSpecialDiscountDate())
                return 1000;
        }
        return 0;
    }

    public double giftApply(double beforeDiscountAmount) {
        if (beforeDiscountAmount >= 120000) {
            return 25000;
        }
        return 0;
    }

    public boolean weekDayApply(int targetDay) {
        for (Date date : calendar) {
            if (date.getDate() == targetDay && date.isWeekDay()) {
                return true;
            }
        }
        return false;
    }
}