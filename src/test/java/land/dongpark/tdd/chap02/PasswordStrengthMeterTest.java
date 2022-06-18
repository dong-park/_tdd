package land.dongpark.tdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {

    @Test
    void name() {
        /*
        길이가 8글자 이상
        0부터 9사이의 숫자를 포함, 대문자 포함, 특수문자 포함
        세 규칙을 한개씩 더 충족할수록 약함, 보통, 강함
         */

    }

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String s, PasswordStrength strong) {
        PasswordStrength result2 = meter.meter(s);
        assertEquals(strong, result2);
    }

    @Test
    void 모든조건을_충족하는경우(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void 문자열의_길이가_8글자미만_나머지_충족(){
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test
    void 숫자를_포함하지_않고_나머지_조건은_충족하는_경우(){
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void 입력이_null인_경우에_대한_테스트_추가() {
        assertStrength(null, PasswordStrength.INVALID);
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void 대문자를_포함하지_않고_나머지_조건을_충족하는_경우(){
        assertStrength("abcd123!@#", PasswordStrength.NORMAL);
    }

    @Test
    void 길이가_8글자_이상인_조건만_충족하는_경우(){
        assertStrength("abcdefghi", PasswordStrength.WEAK);
    }

    @Test
    void 숫자_포함_조건만_충족하는_경우(){
        assertStrength("1234567", PasswordStrength.WEAK);
    }

    @Test
    void 대문자_포함_조건만_충족하는_경우(){
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    void 아무_조건도_충족하지_않는경우(){
        assertStrength("abc", PasswordStrength.INVALID);
    }

}
