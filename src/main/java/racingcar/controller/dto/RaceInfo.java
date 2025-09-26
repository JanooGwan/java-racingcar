package racingcar.controller.dto;

import racingcar.model.Car;

import java.util.List;

public record RaceInfo(
        List<Car> cars,
        int gameCount
) {
}
