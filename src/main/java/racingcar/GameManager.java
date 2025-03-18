package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    GameInformation gi;

    public void startGame() {
        InformationGetter ig = new InformationGetter();
        gi = new GameInformation(ig.getCars(), ig.getTryCount());

        raceStart();
    }

    private void raceStart() {
        int cnt = gi.getTryCount();

        while(cnt > 0) {
            moveCars();
            printRaceStatus();
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

    private void printRaceStatus() {
        System.out.print('\n');

        for(var c : gi.getCars()) {
            System.out.println(c.getName() + " : " + "-".repeat(c.getLocation()));
        }
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
        System.out.println("최종 우승자 : " + findWinners());
    }
}
