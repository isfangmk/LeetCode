package 滑动窗口.q209_长度最小的子数组;


import org.junit.Test;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找
 * 出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class Solution {


    @Test
    public void test() {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, arr));
    }
    public int minSubArrayLen(int s, int[] nums) {

        int lo = 0, hi = 0, sum = 0, len = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            // 保持性质：[lo, hi) >= s
            while (sum >= s) {
                len = Math.min(len, hi - lo);
                sum -= nums[lo++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
