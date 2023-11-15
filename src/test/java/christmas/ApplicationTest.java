package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.Calendar;
import christmas.model.MenuBoard;
import christmas.model.Order;
import christmas.model.OrderValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    MenuBoard menu = new MenuBoard();
    Calendar calendar = new Calendar();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("음료 메뉴만 입력했을 경우 예외가 발생한다.")
    @Test
    void onlyBeverageTest() {
        assertSimpleTest(() -> {
            runException("3","제로콜라-2,샴페인-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("메뉴 개수가 20개를 초과하는 경우 예외가 발생한다.")
    @Test
    void isExceed20Test() {
        assertSimpleTest(() -> {
            runException("25","양송이수프-1,타파스-1,시저샐러드-1,티본스테이크-1,바비큐립-15,해산물파스타-2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력했을 경우 예외가 발생한다.")
    @Test
    void noMenuHereTest() {
        assertSimpleTest(() -> {
            runException("5","투움바파스타-1,제로콜라-1,타파스-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("입력한 메뉴의 개수가 1이상이 아닌 경우 예외가 발생한다.")
    @Test
    void amountIsMoreThanOne() {
        assertSimpleTest(() -> {
            runException("5","제로콜라-1,해산물파스타-0,타파스-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("주문 인풋의 형식이 맞지 않는 경우 예외가 발생한다.")
    @Test
    void orderInputTest() {
        assertSimpleTest(() -> {
            runException("3","해산물파스타-1, 제로콜라-1,타파스-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("주문한 메뉴가 1만원 미만인 경우 혜택이 없다는 안내 메세지를 출력한다.")
    @Test
    void noBenefitMessageTest() {
        assertSimpleTest(() -> {
            runException("3","타파스-1");
            assertThat(output()).contains("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        });
    }

    @DisplayName("중복된 메뉴를 입력했을 경우 예외가 발생한다.")
    @Test
    void createOrderByDuplicatedString() {
        assertThatThrownBy(() -> new Order("시저샐러드-1,시저샐러드-1,초코케이크-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문한 메뉴의 수량을 가져온다.")
    @Test
    void getQuantityTest() {
        Order order = new Order("타파스-1");
        for (String str : order.getOrderMenu()) {
            assertThat(order.getQuantity(str)).isEqualTo(1);
        }
    }

    @DisplayName("1이상 31이하가 아닌 방문일을 입력했을 경우 예외가 발생한다.")
    @Test
    void visitDateTest() {
        String visitDate = "32";
        assertThatThrownBy(() -> new OrderValidator(visitDate))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 메뉴를 입력했을 때 가격을 올바르게 리턴하는지 확인한다.")
    @Test
    void getMenuPriceTest() {
        String name = "타파스";
        double price = 5500;
        assertThat(price).isEqualTo(menu.getMenuPrice(name));
    }

    @DisplayName("디저트가 아닌 경우에 디저트 할인 가격을 0으로 계산하는지 확인한다.")
    @Test
    void calculateDessertAmountExceptionTest() {
        String name = "티본스테이크";
        assertThat(0.0).isEqualTo(menu.calculateDessertAmount(name,2));
    }

    @DisplayName("디저트인 경우 디저트 할인 가격을 올바르게 계산하는지 확인한다.")
    @Test
    void calculateDessertAmountTest() {
        String name = "초코케이크";
        assertThat(4046.0).isEqualTo(menu.calculateDessertAmount(name,2));
    }

    @DisplayName("메인메뉴가 아닌 경우 메인 할인 가격을 0으로 계산하는지 확인한다.")
    @Test
    void calculateMainDishExceptionTest() {
        String name = "아이스크림";
        assertThat(0.0).isEqualTo(menu.calculateMainDish(name,5));
    }

    @DisplayName("메인메뉴인 경우 메인 할인 가격을 올바르게 계산하는지 확인한다.")
    @Test
    void calculateMainDishTest() {
        String name = "크리스마스파스타";
        assertThat(2023.0).isEqualTo(menu.calculateMainDish(name,1));
    }

    @DisplayName("크리스마스 디데이 할인 기간에 포함되지 않는 경우 0을 리턴하는지 확인한다.")
    @Test
    void christmasDiscountApplyExceptionTest() {
        int day = 31;
        assertThat(0.0).isEqualTo(calendar.christmasDiscountApply(day));
    }

    @DisplayName("크리스마스 디데이 할인 기간에 포함되는 경우 할인 가격을 올바르게 계산하는지 확인한다.")
    @Test
    void christmasDiscountApplyTest() {
        int day = 25;
        assertThat(3400.0).isEqualTo(calendar.christmasDiscountApply(day));
    }

    @DisplayName("특별 할인 기간에 포함되지 않는 경우 0을 리턴하는지 확인한다.")
    @Test
    void specialDiscountApplyExceptionTest() {
        int day = 13;
        assertThat(0.0).isEqualTo(calendar.specialDiscountApply(day));
    }

    @DisplayName("특별 할인 기간에 포함되는 경우 1000원을 올바르게 리턴하는지 확인한다.")
    @Test
    void specialDiscountApplyTest() {
        int day = 25;
        assertThat(1000.0).isEqualTo(calendar.specialDiscountApply(day));
    }

    @DisplayName("증정 할인 이벤트에 해당되지 않는 경우 0을 리턴하는지 확인한다.")
    @Test
    void giftApplyExceptionTest() {
        double amount = 5000;
        assertThat(0.0).isEqualTo(calendar.giftApply(amount));
    }

    @DisplayName("증정 할인 이벤트에 해당되는 경우 25000을 리턴하는지 확인한다.")
    @Test
    void giftApplyTest() {
        double amount = 120000;
        assertThat(25000.0).isEqualTo(calendar.giftApply(amount));
    }

    @DisplayName("주말인 경우 평일 이벤트에 해당되지 않아 false를 리턴하는지 확인한다.")
    @Test
    void weekDayApplyExceptionTest() {
        int day = 1;
        assertThat(false).isEqualTo(calendar.weekDayApply(day));
    }

    @DisplayName("평일인 경우 평일 이벤트에 해당됨을 올바르게 리턴하는지 확인한다.")
    @Test
    void weekDayApplyTest() {
        int day = 25;
        assertThat(true).isEqualTo(calendar.weekDayApply(day));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
