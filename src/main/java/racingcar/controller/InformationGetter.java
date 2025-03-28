package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.AcceptingInputPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationGetter {
    Scanner sc = new Scanner(System.in);
    AcceptingInputPrinter inputPrinter = new AcceptingInputPrinter();

    public List<Car> getCars() {
        inputPrinter.printCarNameInputs();
        return analyzeCarString(sc.nextLine());
    }

    private List<Car> analyzeCarString(String carStr) {
        List<Car> cars = new ArrayList<>();

        for(var c : carStr.split(",")) {
            if(c.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");

            if(c.isEmpty()) throw new IllegalArgumentException("이름이 존재하지 않는 자동차가 있습니다.");

            cars.add(new Car(c));
        }

        return cars;
    }

    public int getTryCount() {
        try {
            inputPrinter.printTryCountInputs();
            return sc.nextInt();
        }

        catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
