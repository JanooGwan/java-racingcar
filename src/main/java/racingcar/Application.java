package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;

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
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("이름은 쉼표(,) 기준으로 구분");

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(",");
        Car[] cars = new Car[1000];

        for(int i=0; i<arr.length; i++) cars[i]=new Car(arr[i]);

        System.out.println("몇 회 시도하실 건가요?");
        int n = sc.nextInt();

    }
}
