package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationGetter {
    Scanner sc = new Scanner(System.in);

    public List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("자동차 이름은 쉼표로 구분하여 작성해주세요.");
        System.out.println("ex) pobi,woni,jun");
        System.out.print("\n입력 : ");

        return analyzeCarString(sc.nextLine());
    }

    private List<Car> analyzeCarString(String carStr) {
        List<Car> cars = new ArrayList<>();

        for(var c : carStr.split(",")) {
            cars.add(new Car(c));
        }

        return cars;
    }

    public int getTryCount() {
        System.out.println("\n시도할 회수는 몇 회인가요?");
        System.out.print("\n입력 : ");

        return sc.nextInt();
    }
}
