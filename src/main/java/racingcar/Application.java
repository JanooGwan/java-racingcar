package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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
    public static void moving_car(Car[] car, int n) {
        for (int i = 0; i < n; i++) {
            car[i].move();
            car[i].result_print();
        }
    }

    public static boolean checking_length(String[] str) {
        boolean stat=true;
        for (String s : str) {
            if (s.length() > 5) stat = false;
        }

        return stat;
    }
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("이름은 쉼표(,) 기준으로 구분, 5자 이하 입력");

        String str = Console.readLine();

        if(str.contains(",,"))
            throw new IllegalArgumentException("잘못된 입력 : 쉼표가 연속으로 있음");

        String[] arr = str.split(",");

        if(!checking_length(arr))
            throw new IllegalArgumentException("잘못된 입력 : 이름이 5자를 초과하였음");

        Car[] cars = new Car[1000];

        for(int i=0; i<arr.length; i++)
            cars[i]=new Car(arr[i]);

        System.out.println("몇 회 시도하실 건가요?");
        String p = Console.readLine();
        String pp = p.replaceAll("[\\d]", "");
        System.out.println(pp);

        if(!pp.isBlank())
            throw new IllegalArgumentException("잘못된 입력 : 숫자만 입력되어야 함");

        int n = Integer.parseInt(p);

        while (n>0)
        {
            moving_car(cars, arr.length);
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
