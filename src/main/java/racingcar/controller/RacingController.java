package racingcar.controller;

import racingcar.controller.dto.RaceInfoRequest;
import racingcar.controller.dto.RaceInfoResponse;
import racingcar.util.TryCountValidator;
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

    public RacingController(InputView inputView, OutputView outputView, RaceManager raceManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceManager = raceManager;
    }

    public RaceInfoResponse getInfosBeforeRaceStart() {
        outputView.getCars();

        String racerStr = inputView.getStringInput();
        List<Car> cars = StringUtils.makeCarsUsingString(racerStr);

        outputView.getTryCount();
        int tryCnt = inputView.getNumInput();
        TryCountValidator.isPositive(tryCnt);

        return new RaceInfoResponse(cars, tryCnt);
    }

    public void raceStart(RaceInfoResponse raceInfo) {
        List<Car> cars = StringUtils.makeCarsUsingString(raceInfo.carNames());

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
