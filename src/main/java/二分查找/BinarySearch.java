package 二分查找;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 23:43
 */
public class BinarySearch {

    @Test
    public void test1() {
        int[] nums = {1, 2, 6, 7};
        System.out.println(find(nums, 8));
    }

    /**
     * 无重复数组中查找等于target元素的位置
     * @param nums
     * @param target
     * @return
     */
    public int findEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 查找第一个大于等于target
     * @param nums
     * @param target
     * @return
     */
    public int findFirstNotLess(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        // 如果不存在 right=len
        return right;
    }

    /**
     * 查找第一个大于target元素的位置
     * @param nums
     * @param target
     * @return
     */
    public int findFirstGreater(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    // 目标值最接近的数
    public int find(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (right == nums.length) return nums[right - 1];
        return Math.abs(nums[right] -target) < Math.abs(target - nums[right - 1]) ? nums[right] : nums[right - 1];
    }
}
