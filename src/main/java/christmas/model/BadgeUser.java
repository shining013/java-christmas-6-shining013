package christmas.model;

public class BadgeUser {

    public String calculateBadge(double total) {
        Badge badge;
        badge = Badge.NON;
        if (total >= 5000) {
            badge = Badge.STAR;
        }
        if (total >= 10000) {
            badge = Badge.TREE;
        }
        if (total >= 20000) {
            badge = Badge.SANTA;
        }
        if (total <= 5000) {
            badge = Badge.NON;
        }
        return badge.badgeName;
    }
}