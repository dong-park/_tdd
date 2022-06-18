package land.dongpark.tdd.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate expiry(PayData payData) {
        int plusMonth = (payData.getPayAmount() / 10000);

        LocalDate nextDate =
                payData.getPayAmount() >= 100000 ?
                        payData.payDate.plusMonths(12)
                        : payData.payDate.plusMonths(plusMonth);
        if (payData.getBillingDateStart() != null) {
            if (payData.getBillingDateStart().getDayOfMonth() != payData.getPayDate().getDayOfMonth()) {
                if(nextDate.lengthOfMonth() != payData.getBillingDateStart().getDayOfMonth()){

                }
                return nextDate.withDayOfMonth(payData.getBillingDateStart().getDayOfMonth());
            }
        }

        return nextDate;
    }

}
