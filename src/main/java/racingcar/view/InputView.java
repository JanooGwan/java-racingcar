package racingcar.view;

import java.util.Scanner;

public class InputView {
    public String getStringInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getNumInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
