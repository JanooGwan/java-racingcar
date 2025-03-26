package racingcar.controller;

import racingcar.model.GameInformation;
import racingcar.view.AcceptingInputPrinter;
import racingcar.view.ResultPrinter;

import java.util.Random;

public class GameManager {
    GameInformation gi;
    AcceptingInputPrinter aip = new AcceptingInputPrinter();
    ResultPrinter rp = new ResultPrinter();

    public void startGame() {
        InformationGetter ig = new InformationGetter();
        gi = new GameInformation(ig.getCars(), ig.getTryCount());

        raceStart();
    }

    private void raceStart() {
        int cnt = gi.getTryCount();

        System.out.println("\n\n실행 결과");

        while(cnt > 0) {
            moveCars();
            rp.printRaceStatus(gi);
            --cnt;
        }

        rp.printWinners(gi);
    }

    private void moveCars() {
        for(var c : gi.getCars()) {
            if(judgeMovingCar()) c.move();
        }
    }

    private boolean judgeMovingCar() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }


}
