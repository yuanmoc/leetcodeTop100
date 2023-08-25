package doublePointer;

public class L11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, tmp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    // 暴力法
    public static int maxArea1(int[] height) {
        int max = 0;
        int left = 0,  right = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                double pow = Math.min(height[i], height[j]) * (j - i);
                if (pow > max) {
                    left = i;
                    right = j;
                    max = (int) pow;
                }
            }
        }
        return max;
    }

}
