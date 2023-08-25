package slidingWindow;

/**
 *
 */
public class L3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < chars.length; right++) {
            int tmp = left;
            while (tmp < right) {
                if (s.charAt(tmp++) == s.charAt(right)) {
                    left = tmp;
                    break;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
