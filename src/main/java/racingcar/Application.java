package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
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
    public void judge_winner() {

    }
    public void print_result() {

    }
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("이름은 쉼표(,) 기준으로 구분");

        String str = Console.readLine();
        String[] arr = str.split(",");
        Car[] cars = new Car[1000];

        for(int i=0; i<arr.length; i++)
            cars[i]=new Car(arr[i]);

        System.out.println("몇 회 시도하실 건가요?");
        String p = Console.readLine();
        int n = Integer.parseInt(p);

        while (n>0)
        {
            for (int j = 0; j < arr.length; j++) {
                cars[j].move();
                cars[j].result_print();
            }
            System.out.print('\n');
            n--;
        }

        int max_pos=0;
        for(int i=0; i<arr.length; i++)
            if (cars[i].pos>max_pos) max_pos=cars[i].pos;

        List<String> winners = new ArrayList<String>();
        for(int i=0; i<arr.length; i++)
            if (cars[i].pos==max_pos) winners.add(cars[i].name);

        String r_winners = winners.toString();
        System.out.print("최종 우승자 : " + r_winners.replace("[", "").replace("]", ""));
    }
}
