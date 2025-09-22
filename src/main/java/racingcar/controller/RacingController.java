package racingcar.controller;

import racingcar.controller.dto.RacerInfo;
import racingcar.util.StringUtils;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;


    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public RacerInfo getInfosBeforeRaceStart() {
        outputView.getCars();
        String racerStr = inputView.getStringInput();
        List<Car> cars = StringUtils.makeCarsUsingString(racerStr);

        outputView.getTryCount();
        int tryCnt = inputView.getNumInput();

        return new RacerInfo(cars, tryCnt);
    }

    public void raceStart(RacerInfo racerInfo) {
        for(int i = 0; i < racerInfo.gameCount(); ++i) {
            for(var c : racerInfo.cars()) {
                c.move();
            }

            outputView.
        }
    }
}
