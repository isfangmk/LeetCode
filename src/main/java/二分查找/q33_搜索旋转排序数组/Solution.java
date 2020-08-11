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
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            //处理重复数字
            while(lo < hi && nums[lo] == nums[lo + 1]) ++lo;
            while(lo < hi &&nums[hi] == nums[hi - 1]) --hi;
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
