package racingcar.controller;

import racingcar.model.GameInformation;
import racingcar.view.ResultPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameManager {
    GameInformation gameInfo;
    ResultPrinter resultPrinter = new ResultPrinter();

    private final static int MIN_MOVE_CONDITION = 4;

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

        resultPrinter.printWinners(findWinners(gameInfo));
    }

    private List<String> findWinners(GameInformation gi) {
        int max = 0;

        for(var c : gi.getCars()) {
            max = Math.max(c.getLocation(), max);
        }

        List<String> winners = new ArrayList<>();

        for(var c : gi.getCars()) {
            if(c.getLocation() == max) winners.add(c.getName());
        }

        return winners;
    }

    private void moveCars() {
        for(var c : gameInfo.getCars()) {
            if(judgeMovingCar()) c.move();
        }
    }

    private boolean judgeMovingCar() {
        Random random = new Random();

        return random.nextInt(10) >= MIN_MOVE_CONDITION;
    }
}
