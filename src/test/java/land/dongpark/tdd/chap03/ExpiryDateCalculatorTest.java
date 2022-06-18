package land.dongpark.tdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    /*
    -서비스를 사용하려면 매달 1만 원을 선불로 납부한다.
    납부일 기준으로 한달뒤가 서비스 만료일이 된다.
    -2개월 이상 요금을 납부할 수 있다.
    -10만 원을 납부하면 서비스를 1년 제공한다.
     */

    ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();

    @Test
    void 십만원을_납부하면_서비스를_1년제공(){
        assertEquals(expiryDateCalculator.expiry(1000000), LocalDate.now().plusMonths(12));
        assertNotEquals(expiryDateCalculator.expiry(90000), LocalDate.now().plusMonths(12));
    }

    @Test
    void 서비스를_사용하려면_매달_1만원을_선불로_납부한다(){
        assertEquals(expiryDateCalculator.expiry(10000), LocalDate.now().plusMonths(1));
    }


}
