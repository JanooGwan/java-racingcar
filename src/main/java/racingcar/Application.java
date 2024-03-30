package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

class Car {
    int pos=0;
    String name;
    public Car(String name) {
        this.name=name;
    }

    public void move() {
        int n=Randoms.pickNumberInRange(0,9);
        if (n>=4) pos+=n;
    }

    public void result_print() {
        System.out.println(this.name + " : " + this.pos);
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 ")
    }
}
