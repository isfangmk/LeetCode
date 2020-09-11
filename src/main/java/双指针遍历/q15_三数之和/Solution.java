package 双指针遍历.q15_三数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmk
 * @date 2020/8/9 20:09
 */
public class Solution {


    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            twoSum(nums, left, right, nums[i]);
        }
        return res;
    }
    public void twoSum(int[] nums, int left, int right, int target) {
        while (left < right) {
            int sum = target + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(target, nums[left], nums[right]));
                while (left < right && nums[left] == nums[left+1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right-1]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
