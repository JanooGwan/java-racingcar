package racingcar.model;

public class Car {
    String name;
    int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        ++location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
