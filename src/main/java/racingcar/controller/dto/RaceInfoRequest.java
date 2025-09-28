package racingcar.controller.dto;

import racingcar.model.Car;

import java.util.List;

public record RaceInfoRequest(
        List<String> carNames,
        int gameCount
) {
}
