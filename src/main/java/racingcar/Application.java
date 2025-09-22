package racingcar;

import racingcar.controller.RacingController;
import racingcar.controller.dto.RaceInfo;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();

        RaceInfo raceInfo = racingController.getInfosBeforeRaceStart();
        racingController.raceStart(raceInfo);
    }
}
