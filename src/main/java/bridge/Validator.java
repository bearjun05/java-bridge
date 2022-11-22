package bridge;

import bridge.utils.Stairs;

public class Validator {
    public static final int MINIMUM_SIZE = 3;
    public static final int MAXIMUM_SIZE = 20;

    public static void validateSizeRange(int size) {
        if (size < MINIMUM_SIZE || size > MAXIMUM_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상이거나 20 이하여야 합니다.");
        }
    }

    public static int validateIsDigit(String length) {
        for (int i = 0; i < length.length(); i++) {
            if (!Character.isDigit(length.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자로 입력 해야 합니다.");
            }
        }
        return Integer.parseInt(length);
    }

    public static String validateIsCorrectValue(String value) {
        if (!value.equals(Stairs.UP_STAIRS.getAbbreviation()) && !value.equals(Stairs.DOWN_STAIRS.getAbbreviation())) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U(위 칸), D(아래 칸) 둘 중 하나를 입력하셔야 합니다.");
        }
        return value;
    }
}
