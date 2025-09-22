package racingcar.view;

import racingcar.util.StringUtils;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRaceStatus(List<Car> cars) {
        System.out.println("실행 결과");
        for(var c : cars) {
            System.out.println(c.getName() + " : " + StringUtils.NumToSticks(c.getLocation()));
        }
        System.out.print('\n');
    }

    public void printRaceFinalStatus(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
