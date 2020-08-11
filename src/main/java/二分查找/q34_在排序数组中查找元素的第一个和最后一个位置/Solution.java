package 二分查找.q34_在排序数组中查找元素的第一个和最后一个位置;

import org.junit.Test;
import 二分查找.BinarySearch;

/**
 * @author fmk
 * @date 2020/8/10 23:22
 */
public class Solution {
    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void test() {
        int[] nums = {0, 1, 1, 1, 2};
        System.out.println(findFirstPosition(nums, 1));
        System.out.println(findLastPosition(nums, 1));
    }

    // 第一个大于等于target元素的位置
    private int findFirstPosition(int[] nums, int target) {
        int index = binarySearch.findFirstNotLess(nums, target);
        return nums[index] == target ? index : -1;
    }
    // 最后一个小于等于target元素的位置
    private int findLastPosition(int[] nums, int target) {
        int index = binarySearch.findFirstGreater(nums, target);
        return nums[index - 1] == target ? index - 1 : -1;

    }
}
