package 二分查找;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 23:43
 */
public class BinarySearch {

    @Test
    public void test1() {
        int[] nums = {2, 4, 5, 5, 9};
        System.out.println(findEqual(nums, 5));
        System.out.println(findFirstNotLess(nums, 3));
        System.out.println(findFirstNotLess(nums, 5));

        System.out.println("-------------------------");
        System.out.println(findFirstGreater(nums, 6));
    }

    /**
     * 查找等于target元素的位置
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
            else right = mid;
        }
        return -1;
    }

    /**
     * 查找第一个不小于target元素的位置,也就是第一个大于等于target
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
}
