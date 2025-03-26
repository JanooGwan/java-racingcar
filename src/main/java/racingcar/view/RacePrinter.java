package racingcar.view;

public class RacePrinter {
    public void printCarNameInputs() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("자동차 이름은 쉼표로 구분하여 작성해주세요.");
        System.out.println("ex) pobi,woni,jun");
        System.out.print("입력 : ");
    }

    public void printTryCountInputs() {
        System.out.println("\n시도할 회수는 몇 회인가요?");
        System.out.print("입력 : ");
    }
}
