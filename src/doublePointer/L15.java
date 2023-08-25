package doublePointer;

import utils.ArrayUtil;
import utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class L15 {

    public static void main(String[] args) {
        int[] randomArray = ArrayUtil.getRandomArray(10, -10, 10);
        List<List<Integer>> lists = threeSum(randomArray);
        StringUtil.print(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) {
            return res;
        }
        // 复杂算法，可以使用排序工具类
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 枚举第一个数
            int first = nums[i];
            if (first > 0) {
                return res;
            }
            // 去重，已经出现的序列，就不需要了
            if (i > 0 && first == nums[i-1]) {
                continue;
            }
            int left = i+1, right = len - 1;
            while (left < right) {
                // 假设成立
                int num = first + nums[left] + nums[right];
                if (num == 0) {
                    res.add(Arrays.asList(first, nums[left], nums[right]));
                    // 去重，已经出现的序列，就不需要了
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    // 去重，已经出现的序列，就不需要了
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                }
                // 不成立，大于0就向前处理
                if (num > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
