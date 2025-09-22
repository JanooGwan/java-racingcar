package racingcar.controller.dto;

import java.util.List;

public record RaceFinalResultOutputDto (
        List<String> winners
) {
}
