package christmas.model;

public enum Badge {
    NON(0,"없음"),
    STAR(5000,"별"),
    TREE(10000,"트리"),
    SANTA(20000,"산타");
    private final String badgeName;

    Badge(double totalBenefitAmount, String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeName(Badge badge) {
        return this.badgeName;
    }
}
