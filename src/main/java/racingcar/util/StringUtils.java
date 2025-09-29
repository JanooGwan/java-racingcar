package racingcar.util;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitByComma(String str) {
        return Arrays.stream(str.split(",")).toList();
    }

    public static String NumToSticks(int count) {
        return "-".repeat(count);
    }

    public static List<Car> makeCarsUsingStrings(List<String> strs) {
        return strs.stream().map(Car::new).toList();
    }
}
