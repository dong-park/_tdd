package land.dongpark.tdd.chap03;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PayData {

    int payAmount;
    LocalDate billingDateStart;
    LocalDate payDate;

}
