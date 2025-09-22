package racingcar.controller.dto;

import racingcar.model.Car;

import java.util.List;

public record RaceStatus(
        List<Car> cars
)
{
}
