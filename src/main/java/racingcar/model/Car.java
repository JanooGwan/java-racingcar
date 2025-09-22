package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
