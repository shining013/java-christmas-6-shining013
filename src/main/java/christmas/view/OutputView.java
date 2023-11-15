package christmas.view;

import java.util.Map;

import christmas.Constants;
import christmas.Util;
public class OutputView {
        public static void Greeting() {
                System.out.println(Constants.GREETING);
        }

        public static void printPreview(int visitDate) {
                System.out.printf("%s%d%s%s\n", Constants.DECEMBER, visitDate,Constants.DATE, Constants.PREVIEW);
                System.out.println();
        }

        public static void printOrderMenu(Map<String, Integer> orderMenu) {
                System.out.println(Constants.PRINT_MENU);
                for (Map.Entry<String, Integer> entry : orderMenu.entrySet()) {
                        String menu = entry.getKey();
                        int quantity = entry.getValue();
                        System.out.println(menu+" "+quantity+Constants.NUMBER);
                }
                System.out.println();
        }

        public static void printBeforeDiscountAmount(double amount) {
                System.out.println(Constants.PRINT_BEFORE_DISCOUNT);
                Util.printFormattedNumber(amount);
        }

        public static void printGiftMenu(double amount) {
                System.out.println();
                System.out.printf("%s",Constants.PRINT_GIFT_MENU);
                System.out.println();
                if (amount >= 120000) {
                        System.out.println(Constants.GIVE_CHAMPAGNE);
                        return;
                }
                System.out.printf("%s\n",Constants.NO);
        }

        public static void printBenefitHistory(double christmas, double weekDay, double weekEnd, double special, double giftAmount) {
                System.out.println();
                System.out.println(Constants.PRINT_BENEFIT_HISTORY);
                if (christmas == 0 && weekDay == 0 && weekEnd == 0 && special == 0 && giftAmount == 0) {
                        System.out.println(Constants.NO);
                }
                printApplyXmas(christmas);
                printApplyWeekDay(weekDay);
                printApplyWeekEnd(weekEnd);
                printApplySpecial(special);
                printApplyGift(giftAmount);
                System.out.println();
        }

        public static void printApplyXmas(double christmas) {
                if (christmas != 0) {
                        System.out.printf("%s",Constants.APPLY_CHRISTMAS_DISCOUNT);
                        Util.printFormattedDiscountNumber(christmas);
                }
        }

        public static void printApplyWeekDay(double weekDay) {
                if (weekDay != 0) {
                        System.out.printf("%s",Constants.APPLY_WEEK_DAY_DISCOUNT);
                        Util.printFormattedDiscountNumber(weekDay);
                }
        }

        public static void printApplyWeekEnd(double weekEnd) {
                if (weekEnd != 0) {
                        System.out.printf("%s",Constants.APPLY_WEEK_END_DISCOUNT);
                        Util.printFormattedDiscountNumber(weekEnd);
                }
        }

        public static void printApplySpecial(double special) {
                if (special != 0) {
                        System.out.printf("%s",Constants.APPLY_SPECIAL_DISCOUNT);
                        Util.printFormattedDiscountNumber(special);
                }
        }

        public static void printApplyGift(double gift) {
                if (gift != 0) {
                        System.out.printf("%s",Constants.APPLY_GIFT_EVENT);
                        Util.printFormattedDiscountNumber(gift);
                }
        }

        public static void printTotalBenefit(double total) {
                System.out.println(Constants.PRINT_TOTAL_BENEFIT);
                if (total == 0) {
                        Util.printFormattedNumber(total);
                        return;
                }
                Util.printFormattedDiscountNumber(total);
        }

        public static void printAfterDiscount(double after) {
                System.out.println();
                System.out.println(Constants.PRINT_AFTER_DISCOUNT);
                Util.printFormattedNumber(after);
                System.out.println();
        }

        public static void printEventBadge(String badge) {
                System.out.println(Constants.PRINT_EVENT_BADGE);
                if (badge == null) {
                        System.out.println(Constants.NO);
                }
                System.out.println(badge);
        }
}