package racingcar.controller;

import racingcar.model.GameInformation;
import racingcar.view.ResultPrinter;

import java.util.Random;

public class GameManager {
    GameInformation gameInfo;
    ResultPrinter resultPrinter = new ResultPrinter();

    public void startGame() {
        InformationGetter ig = new InformationGetter();
        gameInfo = new GameInformation(ig.getCars(), ig.getTryCount());

        raceStart();
    }

    private void raceStart() {
        int cnt = gameInfo.getTryCount();

        System.out.println("\n\n실행 결과");

        while(cnt > 0) {
            moveCars();
            resultPrinter.printRaceStatus(gameInfo);
            --cnt;
        }

        resultPrinter.printWinners(gameInfo);
    }

    private void moveCars() {
        for(var c : gameInfo.getCars()) {
            if(judgeMovingCar()) c.move();
        }
    }

    private boolean judgeMovingCar() {
        Random random = new Random();

        return random.nextInt(10) >= 4;
    }


}
