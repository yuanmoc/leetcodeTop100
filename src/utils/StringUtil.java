package utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String str = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final int strLen = str.length();

    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(RandomUtil.getRandomInt(strLen)));
        }
        return sb.toString();
    }

    public static String[] getRandomStringArray(int len, int count) {
        String[] arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = getRandomString(len);
        }
        return arr;
    }

    public static <T> void print(T[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static <T> void print(List<T> nums) {
        System.out.println(nums);
    }

    public static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
