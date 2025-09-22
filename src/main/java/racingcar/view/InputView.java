package racingcar.view;

import java.util.Scanner;

public class InputView {
    public void getStringInput() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public void getNumInput() {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
    }
}
