package 队列相关.q239_滑动窗口最大值;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmk
 * @date 2020/8/10 8:22
 */
public class Solution {



    @Test
    public void test() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        MonotoneQueue window = new MonotoneQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗⼝的前 k - 1
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);

            }
        }
        return res;

    }
}
