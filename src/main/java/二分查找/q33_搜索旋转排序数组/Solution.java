package 二分查找.q33_搜索旋转排序数组;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 22:39
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution {


    @Test
    public void test() {
        int[] nums = {1,3};
        System.out.println(search(nums, 3));
    }
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // [mid, r]有序
            if (nums[mid] < nums[right]) {
                if (target >= nums[mid + 1] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else { //  [l, mid]有序
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
