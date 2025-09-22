package racingcar.controller.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static String[] splitByComma(String str) {
        return str.split(",");
    }

    public static String NumToSticks(int count) {
        return "-".repeat(count);
    }

    public static List<Car> makeCarsUsingString(String str) {
        String[] strs = StringUtils.splitByComma(str);
        List<Car> cars = new ArrayList<>();

        for (var c : strs) {
            cars.add(new Car(c));
        }

        return cars;
    }
}
