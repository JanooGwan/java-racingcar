package racingcar.util;

public class CheckCarName {
    private static final int NAME_MAX_LENGTH = 5;

    public static void isNull(String name) {
        if(name == null)
            throw new IllegalArgumentException("이름에는 null 값이 들어갈 수 없습니다.");
    }

    public static void isBlank(String name) {
        if(name.isBlank())
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
    }

    public static void isMoreThanMaxLength(String name) {
        if(name.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
    }

    public static void checkName(String name) {
        isNull(name);
        isBlank(name);
        isMoreThanMaxLength(name);
    }
}
