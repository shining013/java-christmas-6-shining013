package christmas.model;

public class Date {
    private final int date;
    private final boolean isChristmasD_dayDiscount;
    private final boolean isSpecialDiscountDate;
    private final boolean isWeekDay;

    public Date(int date, boolean isChristmasD_dayDiscount, boolean isSpecialDiscountDate, boolean isWeekDay) {
        this.date = date;
        this.isChristmasD_dayDiscount = isChristmasD_dayDiscount;
        this.isSpecialDiscountDate = isSpecialDiscountDate;
        this.isWeekDay = isWeekDay;
    }

    public int getDate() {
        return date;
    }

    public boolean isChristmasD_dayDiscount() {
        return isChristmasD_dayDiscount;
    }

    public boolean isSpecialDiscountDate() {
        return isSpecialDiscountDate;
    }

    public boolean isWeekDay() {
        return isWeekDay;
    }
}