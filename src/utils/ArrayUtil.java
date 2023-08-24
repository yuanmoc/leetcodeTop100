package utils;

import java.util.Arrays;

public class ArrayUtil {

    public static int[] getRandomArray(int len) {
        return getRandomArray(len, 10);
    }

    public static int[] getRandomArray(int len, int maxNum) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = RandomUtil.getRandomInt(maxNum);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }


}
