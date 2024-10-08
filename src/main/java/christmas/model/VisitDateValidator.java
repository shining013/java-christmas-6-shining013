package christmas.model;

import christmas.Constants;

public class VisitDateValidator {
    private final String visitDate;

    public VisitDateValidator(String visitDate) {
        this.visitDate = visitDate;
        isDateValid();
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void isDateValid() {
        int visitDate = Integer.parseInt(this.visitDate);
        if (visitDate < 1 || visitDate > 31) {
            throw new IllegalArgumentException(Constants.INVALID_DATE_ERROR);
        }
    }

    @Override
    public String toString() {
        return String.format("방문 예정일 (날짜 = %s)", visitDate);
    }
}