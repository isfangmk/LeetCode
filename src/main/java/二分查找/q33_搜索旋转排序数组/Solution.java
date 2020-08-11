package 二分查找.q33_搜索旋转排序数组;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 22:39
 */
public class Solution {


    @Test
    public void test() {
        int[] nums = {4,5,5,6, 6, 4,4};
        System.out.println(search(nums, 6));
    }
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 先根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
            if (target >= nums[0]) {
                // 目标值在左半段时，若 mid 在右半段，则将 mid 索引的值改成 inf
                // 查找6
                // {4,5,6,3, 3, 4,4};
                // {4, 5, 6, inf, inf, inf, inf}
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段时，若 mid 在左半段，则将 mid 索引的值改成 -inf
                // 查找2
                // {3, 3, 7, 8, 9, 2, 2};
                // {-inf, -inf, -inf, -inf, 9, 2, 2}
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
