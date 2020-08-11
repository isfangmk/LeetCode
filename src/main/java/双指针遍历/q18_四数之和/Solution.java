package 双指针遍历.q18_四数之和;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmk
 * @date 2020/8/10 21:07
 */
public class Solution {


    @Test
    public void test() {
        int[] arr = {1,-2,-5,-4,-3,3,3,5};

        System.out.println(fourSum(arr, -11));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            //最小的数都大于target的1/4，后面的不用看了
            if(nums[i] > target/4) {
                break;
            }
            // 选定的第一个数去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 三数之和
            for (int j = i + 1; j < len - 2; j++) {
                // 第二个数去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                // 寻找两个数满足nums[left] + nums[right] + nums[i] + nums[j] = target
                while (left < right) {
                    //最大的都小于targer的1/4，后面的不用看了
                    if(nums[right]<target/4) {
                        break;
                    }
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i],  nums[j], nums[left], nums[right]));
                        // 选定的后两个数去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
