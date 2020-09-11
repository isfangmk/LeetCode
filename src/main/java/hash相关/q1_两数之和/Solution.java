package hash相关.q1_两数之和;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fmk
 * @date 2020/8/9 17:33
 */
public class Solution {


    @Test
    public void test() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    // 使用HashMap,不能有相同的元素
    // 时间复杂度O(n),空间复杂度O(n)
    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;

    }

}
