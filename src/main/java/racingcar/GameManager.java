package racingcar;

import java.util.List;

public class GameManager {

    public void startGame() {
        InformationGetter ig = new InformationGetter();
        GameInformation gi = new GameInformation(ig.getCars(), ig.getTryCount());

        raceStart();
    }

    private void raceStart() {

    }
}
