package christmas.model;

public class VisitDate {
    private final int visitDate;

    public VisitDate(int visitDate) {
        this.visitDate = visitDate;
    }

    public int getDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return String.format("방문 예정일 (날짜 = %d)",visitDate);
    }
}
