package christmas;

import java.text.DecimalFormat;
public class Util {

    public static void printFormattedNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        String formattedNumber = decimalFormat.format(number);
        System.out.printf("%s%s\n",formattedNumber,Constants.MONEY_UNIT);
    }

    public static void printFormattedDiscountNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###");
        String formattedNumber = decimalFormat.format(number);
        System.out.printf("%s%s%s\n",Constants.DASH,formattedNumber,Constants.MONEY_UNIT);
    }
}
