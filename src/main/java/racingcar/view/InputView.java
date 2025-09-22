package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public String getStringInput() {
        return sc.nextLine();
    }

    public int getNumInput() {
        try {
            return sc.nextInt();
        }
        catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자 외 다른 형태의 값을 입력할 수 없습니다.");
        }
    }
}
