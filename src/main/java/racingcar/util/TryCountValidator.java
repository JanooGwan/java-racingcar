package racingcar.util;

public class TryCountValidator {
    public static void isPositive(int tryCnt) {
        if(tryCnt < 0)
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
    }
}
