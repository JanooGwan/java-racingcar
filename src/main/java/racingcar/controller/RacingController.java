package racingcar.controller;

import racingcar.controller.dto.RacerInfo;
import racingcar.controller.util.StringUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;


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
        List

        outputView.getTryCount();
        int tryCnt = inputView.getNumInput();

        return new RacerInfo(, tryCnt);
    }

    public void raceStart(RacerInfo racerInfo) {

    }
}
