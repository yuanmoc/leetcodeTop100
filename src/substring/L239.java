package substring;

import utils.StringUtil;

import java.util.*;

/**
 *给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class L239 {

    public static void main(String[] args) {
        /**
         * [1,3,1],2,0,5    3
         * 1,[3,1,2],0,5    3
         * 1,3,[1,2,0],5    2
         * 1,3,1,[2,0,5]    5
         */
        int[] ints = maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        StringUtil.print(ints);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> list = new LinkedList<>();
        for (int left = 0; left < len; left++) {
            // 去掉比当前值小的内容
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[left]) {
                list.pollLast();
            }
            // 去掉已经在窗口外的值
            while (!list.isEmpty() && list.peek() <= left-k) {
                list.poll();
            }
            // 把值添加到窗口
            list.offerLast(left);
            if (left + 1 >= k) {
                // 获取最大窗口最大值
                res[left+1-k] = nums[list.peek()];
            }
        }
        return res;
    }
}
