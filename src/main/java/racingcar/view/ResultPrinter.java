package racingcar.view;

import racingcar.model.Car;
import racingcar.model.GameInformation;

import java.util.ArrayList;
import java.util.List;

public class ResultPrinter {
    public void printRaceStatus(GameInformation gi) {
        List<Car> cars = gi.getCars();
        for(var c : cars) {
            System.out.println(c.getName() + " : " + "-".repeat(c.getLocation()));
        }
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

    public void printWinners(GameInformation gi) {
        System.out.print('\n');
        System.out.println("최종 우승자 : " + String.join(", ", findWinners(gi)));
    }
}
