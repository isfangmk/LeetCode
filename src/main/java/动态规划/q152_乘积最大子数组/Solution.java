package 动态规划.q152_乘积最大子数组;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/12 11:45
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxProduct(new int[] {2,-1,1,1}));
    }
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int preMin = nums[0], preMax = nums[0], res = nums[0];
        for (int i = 1; i < len; i++) {
            int curMin = Math.min(Math.min(nums[i] * preMin, nums[i] * preMax), nums[i]);
            int curMax = Math.max(Math.max(nums[i] * preMin, nums[i] * preMax), nums[i]);
            res = Math.max(res, curMax);
            preMax = curMax;
            preMin = curMin;
        }
        return res;
    }
}
