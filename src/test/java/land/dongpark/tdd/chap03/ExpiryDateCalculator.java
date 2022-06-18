package land.dongpark.tdd.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate expiry(int price) {
        return price >= 100000 ? LocalDate.now().plusMonths(12) : LocalDate.now().plusMonths(11);
    }
}
