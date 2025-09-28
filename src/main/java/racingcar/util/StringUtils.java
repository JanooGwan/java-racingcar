package racingcar.util;

import racingcar.model.Car;

public class StringUtils {
    public static String[] splitByComma(String str) {
        return str.split(",");
    }

    public static String NumToSticks(int count) {
        return "-".repeat(count);
    }

    public static Car makeCarUsingString(String str) {
        return new Car(str);
    }
}
