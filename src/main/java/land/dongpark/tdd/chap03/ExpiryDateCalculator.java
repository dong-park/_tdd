package land.dongpark.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

    public LocalDate calculrateExpiry(PayData payData) {
        int plusMonth = (payData.getPayAmount() / 10000);

        LocalDate candidateExp =
                payData.getPayAmount() >= 100000 ?
                        payData.payDate.plusMonths(12)
                        : payData.payDate.plusMonths(plusMonth);
        if (payData.getBillingDateStart() != null) {
            if (payData.getBillingDateStart().getDayOfMonth() != payData.getPayDate().getDayOfMonth()) {
                if(YearMonth.from(candidateExp).lengthOfMonth() < payData.getBillingDateStart().getDayOfMonth()){
                    return candidateExp.withDayOfMonth(candidateExp.lengthOfMonth());
                }
                return candidateExp.withDayOfMonth(payData.getBillingDateStart().getDayOfMonth());
            }
        }

        return candidateExp;
    }

}
