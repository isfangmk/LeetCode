package 双指针遍历.q16_最接近的三数之和;

import java.util.Arrays;

/**
 * @author fmk
 * @date 2020/8/9 23:30
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 与target差值，寻找差值绝对值最小
                int c = sum - target;
                if (Math.abs(c) < Math.abs(res - target)) {
                    res = sum;
                }
                if (c == 0) {
                    return target;
                } else if (c > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
