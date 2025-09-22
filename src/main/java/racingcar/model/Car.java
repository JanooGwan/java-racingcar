package racingcar.model;

public class Car {
    int location;
    String name;


    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void moveForward() {
        if(isAbleToMove()) ++location;
    }

    private boolean isAbleToMove() {
        return (int)(Math.random() * 10) >= 4;
    }
}
