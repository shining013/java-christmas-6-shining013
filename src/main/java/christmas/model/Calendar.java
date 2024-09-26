package christmas.model;

import java.util.ArrayList;
import java.util.Collections;

public class Calendar {
    private final ArrayList<Date> calendar;

    public Calendar() {
        this.calendar = new ArrayList<>();
        Date[] dates = new Date[31];

        for(int i=0;i<=30;i++) {
            dates[i]= new Date(i+1,true,false,false);
        }

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