package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public void movingCars(List<Car> cars) {
        for(var c : cars) c.move();
    }

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = 0;

        for(var c : cars) {
            if(maxLocation < c.getLocation()) maxLocation = c.getLocation();
        }

        List<String> winners = new ArrayList<>();
        for(var c : cars) {
            if(maxLocation == c.getLocation())
                winners.add(c.getName());
        }

        return winners;
    }
}
