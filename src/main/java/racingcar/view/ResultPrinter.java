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

    public void printWinners(List<String> winners) {
        System.out.print('\n');
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
