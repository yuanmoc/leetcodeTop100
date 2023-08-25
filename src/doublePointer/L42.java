package doublePointer;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class L42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int left = 0;
        int sum = 0;
        for (int right = 0; right < height.length; right++) {
            if (height[right] > height[left] && right-left>1) {
                // 计算水量
                int min = Math.min(height[left], height[right]);
                while (left < right) {
                    if (height[left] < min) {
                        sum = min - height[left];
                    }
                    left++;
                }
                left=right;
            }
        }
        return sum;
    }
}
