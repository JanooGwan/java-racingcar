package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static String[] splitByComma(String str) {
        return str.split(",");
    }

    public static String NumToSticks(int count) {
        return "-".repeat(count);
    }

    public static List<Car> makeCarsUsingString(String str) {
        return Arrays.stream(StringUtils.splitByComma(str)).map(Car::new).toList();
    }
}
