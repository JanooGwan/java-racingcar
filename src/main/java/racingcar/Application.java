package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Car {
    int pos=0; // 차 위치
    String stick = "-";
    String name;
    public Car(String name) {
        this.name=name;
    }

    public void move() { // 차 이동
        int n=Randoms.pickNumberInRange(0,9);
        if (n>=4) pos+=1;
    }

    public void result_print() { // 차 상태 출력
        System.out.println(this.name + " : " + stick.repeat(pos));
    }
}

public class Application {
    public static void moving_car(Car[] car, int n) { // 차 이동&상태 출력
        for (int i = 0; i < n; i++) {
            car[i].move();
            car[i].result_print();
        }
    }

    public static boolean checking_length(String[] str) { // 이름 길이 체크, 예외 처리 시 사용
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

        for(int i=0; i<arr.length; i++) // 생성된 이름 개수만큼 객체 생성
            cars[i]=new Car(arr[i]);

        System.out.println("몇 회 시도하실 건가요?");
        String p = Console.readLine();
        String pp = p.replaceAll("[\\d]", ""); // 숫자를 제외한 모든 문자 제거
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
            if (cars[i].pos==max_pos) winners.add(cars[i].name); // 최대 위치에 해당하는 차들을 출력

        String r_winners = winners.toString();
        System.out.print("최종 우승자 : " + r_winners.replace("[", "").replace("]", ""));
        // 우승 자동차 list를 출력할 때 대괄호 제거
    }
}
