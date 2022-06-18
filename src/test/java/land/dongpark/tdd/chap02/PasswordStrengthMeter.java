package land.dongpark.tdd.chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        return getPasswordStrength(getValidPoint(s));
    }

    private PasswordStrength getPasswordStrength(int validPoint) {
        if(validPoint == 0) return PasswordStrength.INVALID;
        else if(validPoint == 1) return PasswordStrength.WEAK;
        else if(validPoint == 2) return PasswordStrength.NORMAL;
        else return PasswordStrength.STRONG;
    }

    private int getValidPoint(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int validPoint = 0;
        boolean isEnoughLength = s.length() >= 8;
        boolean containsNum = isContainsNum(s);
        boolean containsUpp = isUppString(s);
        if(isEnoughLength) validPoint ++;
        if(containsNum) validPoint ++;
        if(containsUpp) validPoint ++;
        return validPoint;
    }

    private boolean isUppString(String s) {
        for(char ch: s.toCharArray()){
            if (ch >= 'A' && ch <= 'Z'){
                return true;
            }
        }
        return false;
    }

    private boolean isContainsNum(String s) {
        boolean containsNum = false;
        for(char ch: s.toCharArray()){
            if (ch >= '0' && ch <= '9'){
                containsNum = true;
                break;
            }
        }
        return containsNum;
    }
}
