package 双指针遍历.q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmk
 * @date 2020/8/9 20:09
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return res;
        }
        int len = nums.length;
        for (int i = 0; i < len- 2; i++) {
            // 选定的第一个值去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = len - 1;
            // 寻找两个数满足nums[left] + nums[right] + nums[i] = 0
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
