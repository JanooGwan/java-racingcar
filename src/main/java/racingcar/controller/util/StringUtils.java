package racingcar.controller.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public List<String> splitByComma(String str) {
        return Arrays.stream(str.split(",")).toList();
    }

    public String NumToSticks(int count) {
        return "-".repeat(count);
    }
}
