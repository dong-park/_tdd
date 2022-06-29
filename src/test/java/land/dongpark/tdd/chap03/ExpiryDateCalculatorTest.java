package land.dongpark.tdd.chap03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ExpiryDateCalculatorTest {

    /*
    -서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한달뒤가 서비스 만료일이 된다.
    -2개월 이상 요금을 납부할 수 있다.
    -10만 원을 납부하면 서비스를 1년 제공한다.
     */

    ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();

    private void assertExpiryDate(PayData payData, LocalDate endDate) {
        assertEquals(expiryDateCalculator.calculrateExpiry(payData), endDate);
    }

    @Test
    void 십만원을_납부하면_서비스를_1년제공(){
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2022, 6, 30))
                .payAmount(100_000)
                .build(), LocalDate.of(2023, 6, 30));
    }

    @Test
    void 서비스를_사용하려면_매달_1만원을_선불로_납부한다(){
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2022, 6, 30))
                .payAmount(10_000)
                .build(), LocalDate.of(2022, 7, 30));
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2022, 6, 15))
                .payAmount(10_000)
                .build(), LocalDate.of(2022, 7, 15));
    }

    @Test
    void 납부일과_만료일의_일자가_맞지않는경우_만원납부(){
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2022, 5, 31))
                .payAmount(10_000)
                .build(), LocalDate.of(2022, 6, 30));
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2020, 1, 31))
                .payAmount(10_000)
                .build(), LocalDate.of(2020, 2, 29));
    }

    @Test
    void 첫_납부일_일자와_만료일_납부일_일자가_다를때_만원납부(){
        assertExpiryDate(PayData.builder()
                .billingDateStart(LocalDate.of(2022, 1, 31))
                .payDate(LocalDate.of(2022, 2, 28))
                .payAmount(10_000)
                .build(), LocalDate.of(2022, 3, 31));
        assertExpiryDate(PayData.builder()
                .billingDateStart(LocalDate.of(2022, 5, 31))
                .payDate(LocalDate.of(2022, 6, 30))
                .payAmount(10_000)
                .build(), LocalDate.of(2022, 7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산(){
        assertExpiryDate(PayData.builder()
                .payDate(LocalDate.of(2022, 2, 28))
                .payAmount(20_000)
                .build(), LocalDate.of(2022, 4, 28));
    }

    @Test
    void 첫_납부일_일자와_만료일_납부일_일자가_다를때_이만원이상납부(){
        assertExpiryDate(PayData.builder()
                .billingDateStart(LocalDate.of(2022, 1, 31))
                .payDate(LocalDate.of(2022, 2, 28))
                .payAmount(20_000)
                .build(), LocalDate.of(2022, 4, 30));
    }

}
