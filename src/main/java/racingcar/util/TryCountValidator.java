package racingcar.util;

public class TryCountValidator {
    public static void isNumber(String tryCnt) {
        try {
            Integer.parseInt(tryCnt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수에 문자를 입력할 수 없습니다.");
        }
    }

    public static void isPositive(int tryCnt) {
        if(tryCnt < 0)
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
    }
}
