package utils;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int getRandomInt(int max) {
        return random.nextInt(0, max);
    }

    public static int getRandomInt(int min , int max) {
        return random.nextInt(min, max);
    }

}
