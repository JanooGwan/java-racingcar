package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public void movingCars(List<Car> cars) {
        for(var c : cars) c.move();
    }

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = cars.stream().mapToInt(Car::getLocation).max().orElse(0);

        List<String> winners = cars.stream().filter(c -> c.getLocation() == maxLocation).map(Car::getName).toList();

        return winners;
    }
}
