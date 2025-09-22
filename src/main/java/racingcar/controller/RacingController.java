package racingcar.controller;

import racingcar.controller.dto.RaceInfo;
import racingcar.util.RaceManager;
import racingcar.util.StringUtils;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceManager raceManager;


    public RacingController() {
        this.inputView =  new InputView();
        this.outputView = new OutputView();
        this.raceManager = new RaceManager();
    }

    public RaceInfo getInfosBeforeRaceStart() {
        outputView.getCars();
        String racerStr = inputView.getStringInput();
        List<Car> cars = StringUtils.makeCarsUsingString(racerStr);

        outputView.getTryCount();
        int tryCnt = inputView.getNumInput();

        return new RaceInfo(cars, tryCnt);
    }

    public void raceStart(RaceInfo raceInfo) {
        List<Car> cars = raceInfo.cars();

        outputView.printRaceStart();

        for(int i = 0; i < raceInfo.gameCount(); ++i) {
            raceManager.movingCars(cars);
            outputView.printRaceStatus(cars);
        }

        finishRace(cars);
    }

    private void finishRace(List<Car> cars) {
        List<String> winners = raceManager.findWinners(cars);
        outputView.printRaceFinalStatus(winners);
    }
}
