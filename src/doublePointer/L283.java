package doublePointer;

import utils.ArrayUtil;
import utils.RandomUtil;
import utils.StringUtil;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class L283 {

    public static void main(String[] args) {
        int[] randomArray = ArrayUtil.getRandomArray(8);
        moveZeroes(randomArray);
        StringUtil.print(randomArray);
    }

    // 双指针
    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
            } else {
                nums[left++] = nums[right++];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                // 要求排序时，可以这样判断
                // nums[j-1] > nums[j] && nums[j] != 0  || nums[j-1] == 0
                // 题目没有要求排序，所以直接判断0就好
                if (nums[j-1] == 0) {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
