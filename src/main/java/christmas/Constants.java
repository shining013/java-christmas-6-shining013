package christmas;

import java.util.regex.Pattern;

public class Constants {
    public static final String DELIMITER = ",";
    public static final String DASH = "-";
    public static final String NO = "없음";
    public static final String DECEMBER = "12월 ";
    public static final String DATE = "일";
    public static final Pattern ORDER_PATTERN = Pattern.compile("^([가-힣]+)" + DASH + "([1-9][0-9]*)(" + DELIMITER + "([가-힣]+)" + DASH + "([1-9][0-9]*))*$");
    public static final String MONEY_UNIT = "원";
    public static final String NUMBER = "개";
    public static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String ENTER_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String ENTER_MENU = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String PREVIEW = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    public static final String PRINT_MENU = "<주문 메뉴>";
    public static final String PRINT_BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    public static final String GIVE_CHAMPAGNE = "샴페인 1개";
    public static final String PRINT_GIFT_MENU = "<증정 메뉴>";
    public static final String PRINT_BENEFIT_HISTORY = "<혜택 내역>";
    public static final String PRINT_TOTAL_BENEFIT = "<총혜택 금액>";
    public static final String PRINT_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    public static final String PRINT_EVENT_BADGE = "<12월 이벤트 배지>";
    public static final String ERROR = "[ERROR] ";
    public static final String INVALID_DATE_ERROR = ERROR + "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String INVALID_ORDER_ERROR = ERROR + "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String EVENT_DO_NOT_APPLY = "총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.";
    public static final String APPLY_CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: ";
    public static final String APPLY_WEEK_DAY_DISCOUNT = "평일 할인: ";
    public static final String APPLY_WEEK_END_DISCOUNT = "주말 할인: ";
    public static final String APPLY_SPECIAL_DISCOUNT = "특별 할인: ";
    public static final String APPLY_GIFT_EVENT = "증정 이벤트: ";
}
