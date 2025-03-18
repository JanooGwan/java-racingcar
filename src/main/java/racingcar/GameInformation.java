package racingcar;

import java.util.List;

public final class GameInformation {
    private final List<Car> cars;
    private final int tryCount;

    public GameInformation(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
