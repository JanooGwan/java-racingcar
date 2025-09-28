package racingcar.controller.dto;

import java.util.List;

public record RaceInfoResponse(
        List<String> carNames,
        int gameCount
) {
}
