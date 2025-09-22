package racingcar.controller.dto;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record RacerInfoInputDto(
        String cars,
        int gameCount
) {
    public List<Car> toCars() {
        return Arrays.stream(cars.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
