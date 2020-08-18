package 动态规划.q_152乘积最大子数组;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/12 11:45
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
    }
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int pre = nums[0], res = 0;
        for (int i = 1; i < len; i++) {
            int t = Math.max(nums[i], nums[i] * pre);
            if (t >= res) {
                res = Math.max(res, t);
                pre = t;
            } else {
                pre = nums[i];
            }
        }
        return res;
    }
}
