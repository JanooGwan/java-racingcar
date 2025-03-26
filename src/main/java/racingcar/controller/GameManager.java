package racingcar.controller;

import racingcar.model.GameInformation;
import racingcar.view.RacePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    GameInformation gi;
    RacePrinter rp = new RacePrinter();

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
            rp.printRaceStatus();
            --cnt;
        }

        printWinners();
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



    private List<String> findWinners() {
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

    private void printWinners() {
        System.out.print('\n');
        System.out.println("최종 우승자 : " + String.join(", ", findWinners()));
    }
}
