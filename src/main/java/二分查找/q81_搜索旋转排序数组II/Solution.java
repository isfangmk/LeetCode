package 二分查找.q81_搜索旋转排序数组II;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 22:39
 */
public class Solution {


    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(search(nums, 1));
    }
    public boolean search(int[] nums, int target) {
        if (nums.length < 1) return false;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < nums[right]) {
                if (target >= nums[mid + 1] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] == target) {
                    return true;
                }
                right--;
            }
        }
        return nums[left] == target;
    }
}
