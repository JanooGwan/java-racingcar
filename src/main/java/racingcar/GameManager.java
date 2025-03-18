package racingcar;

import java.util.List;

public class GameManager {

    public void startGame() {
        InformationGetter ig = new InformationGetter();

        List<Car> cars = ig.getCars();
    }

}
