package christmas.model;

public record Date(int date, boolean ischristmasDDaydiscount, boolean isSpecialDiscountDate, boolean isWeekDay) {

    @Override
    public String toString() {
        return String.format("날짜 (날짜 = %d, 크리스마스 디데이? = %b, 특별 할인? = %b, 평일? = %b)", date, ischristmasDDaydiscount, isSpecialDiscountDate, isWeekDay);
    }
}