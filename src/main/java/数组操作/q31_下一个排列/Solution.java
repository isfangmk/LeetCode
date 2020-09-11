package 数组操作.q31_下一个排列;

import org.junit.Test;

import java.util.Arrays;

/**
 * 以358764为例
 * 1、从右到左，找到第一个左侧小于右侧的下标值i
 * 2、再次从右到左，找到第一个大于nums[i]的数以及下标j，然后i 和 j对应的数进行互换
 * 3、i下标后面的数按从小到大排序
 * 时间复杂度O(n)
 * 空间复杂度为O(1)
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {3,5,8,7,6,4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            flag = true;
            if (nums[i] < nums[i+1]) {
                // 索引i处的元素小于其下一个元素
                for (int j = len - 1; j >= i + 1; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        break;
                    }
                }
                // 对i后面的数排序
                Arrays.sort(nums, i+1, len);
                return;
            }
        }
        if (!flag) {
            int i = 0, j = len - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
