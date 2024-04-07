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
        int n= Randoms.pickNumberInRange(0,9);
        if (n>=4) pos+=1;
    }

    public void result_print() { // 차 상태 출력
        System.out.println(this.name + " : " + stick.repeat(pos));
    }
}

class GameManager {
    Car[] cars;
    int playTimes;
    int max_pos=0;
    List<String> winners = new ArrayList<String>();

    public GameManager(Car[] cars, int playTimes) {
        this.cars=cars;
        this.playTimes=playTimes;
    }

    public void playGame() {
        while (playTimes>0) {
            for(int i=0; i<this.cars.length; i++) {
                this.cars[i].move();
                this.cars[i].result_print();
            }

            System.out.print('\n');
            --playTimes;
        }
    }

    public void judgeWinners() {
        for(int i=0; i<this.cars.length; i++)
            if (cars[i].pos>max_pos) max_pos=cars[i].pos;

        for(int i=0; i<this.cars.length; i++)
            if (cars[i].pos==max_pos) winners.add(cars[i].name); // 최대 위치에 해당하는 차들을 출력

    }

    public void printWinners() {
        String r_winners = winners.toString();
        System.out.print("최종 우승자 : " + r_winners.replace("[", "").replace("]", ""));
        // 우승 자동차 list를 출력할 때 대괄호 제거
    }
}


class Exceptions {
    public String stat;
    public String checked_str;


    public Exceptions(String str) {
        this.checked_str=str;
    }

    public void reload_str(String str) {
        this.checked_str=str;
    }

    public void length() { // 이름 길이 체크, 예외 처리 시 사용
        String[] arr = checked_str.split(",");
        for (String s : arr) {
            if (s.length() > 5) this.stat = "length";
        }
    }

    public void comma() {
        if (this.checked_str.contains(",,"))
            this.stat = "comma";
    }

    public void only_num() {
        String str_filter = this.checked_str.replaceAll("[\\d]", ""); // 숫자를 제외한 모든 문자 제거

        if(!str_filter.isBlank())
            this.stat = "num";
    }

    public void Throw() {
        if (stat.equals("comma"))
            throw new IllegalArgumentException("잘못된 입력 : 쉼표가 연속으로 있음");

        else if(stat.equals("length"))
            throw new IllegalArgumentException("잘못된 입력 : 이름이 5자를 초과하였음");

        else if(stat.equals("num"))
            throw new IllegalArgumentException("잘못된 입력 : 숫자만 입력되어야 함");

        /*
        switch(stat) {
            case "comma":
                throw new IllegalArgumentException("잘못된 입력 : 쉼표가 연속으로 있음");

            case "length":
                throw new IllegalArgumentException("잘못된 입력 : 이름이 5자를 초과하였음");

            case "num":
                throw new IllegalArgumentException("잘못된 입력 : 숫자만 입력되어야 함");

            default :
                break;
        }
        */

    }
}


class Applicaion {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("이름은 쉼표(,) 기준으로 구분, 5자 이하 입력");

        String str = Console.readLine();

        Exceptions exceptions = new Exceptions(str);

        exceptions.comma();
        exceptions.Throw();
        exceptions.length();
        exceptions.Throw();

        String[] arr = str.split(",");

        Car[] cars = new Car[arr.length];
        for(int i=0; i<arr.length; i++) // 생성된 이름 개수만큼 객체 생성
            cars[i]=new Car(arr[i]);

        System.out.println("몇 회 시도하실 건가요?");
        str = Console.readLine();

        exceptions.reload_str(str);
        exceptions.only_num();
        exceptions.Throw();

        int n = Integer.parseInt(str);

        GameManager GM = new GameManager(cars, n);

        GM.playGame();
        GM.judgeWinners();
        GM.printWinners();

    }
}
