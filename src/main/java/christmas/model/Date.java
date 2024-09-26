package christmas.model;

public class Date {
    private final int date;
    private final boolean ischristmasDDaydiscount;
    private final boolean isSpecialDiscountDate;
    private final boolean isWeekDay;

    public Date(int date, boolean ischristmasDDaydiscount, boolean isSpecialDiscountDate, boolean isWeekDay) {
        this.date = date;
        this.ischristmasDDaydiscount = ischristmasDDaydiscount;
        this.isSpecialDiscountDate = isSpecialDiscountDate;
        this.isWeekDay = isWeekDay;
    }

    public int getDate() {
        return date;
    }

    public boolean isIschristmasDDaydiscount() {
        return ischristmasDDaydiscount;
    }

    public boolean isSpecialDiscountDate() {
        return isSpecialDiscountDate;
    }

    public boolean isWeekDay() {
        return isWeekDay;
    }

    @Override
    public String toString() {
        return String.format("날짜 (날짜 = %d, 크리스마스 디데이? = %b, 특별 할인? = %b, 평일? = %b)", date, ischristmasDDaydiscount, isSpecialDiscountDate, isWeekDay);
    }
}