package christmas.model;

public enum Badge {
    NON("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");
    private final String badgeName;

    Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeName() {
        return this.badgeName;
    }
}
