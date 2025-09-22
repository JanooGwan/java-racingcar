package racingcar.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public String getStringInput() {
        return sc.nextLine();
    }

    public int getNumInput() {
        return sc.nextInt();
    }
}
