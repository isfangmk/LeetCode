package 二分查找.q153_寻找旋转排序数组中的最小值;

/**
 * @author fmk
 * @date 2020/8/11 9:29
 * 假设数组中不存在重复元素
 * [3,4,5,1,2]
 * 1
 */
public class Solution {
    // 数组中第一个小于 nums[end] 的数字
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;

            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
