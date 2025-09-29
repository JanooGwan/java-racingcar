package racingcar.model;

import racingcar.util.CarNameValidator;

public class Car {
    private static final int CAN_MOVE_STANDARD = 4;

    private int location;
    private String name;

    public Car(String name) {
        CarNameValidator.checkName(name);
        this.name = name;
        this.location = 0;
    }

    public void move() {
        if(isAbleToMove()) ++location;
    }

    private boolean isAbleToMove() {
        return (int)(Math.random() * 10) >= CAN_MOVE_STANDARD;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
