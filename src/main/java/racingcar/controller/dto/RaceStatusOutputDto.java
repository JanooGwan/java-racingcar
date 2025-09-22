package racingcar.controller.dto;

import racingcar.model.Car;

import java.util.List;

public record RaceStatusOutputDto(
        List<Car> cars
)
{
}
