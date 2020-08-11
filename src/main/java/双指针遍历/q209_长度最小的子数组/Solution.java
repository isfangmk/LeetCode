package 双指针遍历.q209_长度最小的子数组;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/9 23:50
 */
public class Solution {



    @Test
    public void test() {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        int lo = 1, hi = nums.length, min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (windowExist(mid, nums, s)) {
                hi = mid - 1;//找到就缩小窗口的大小
                min = mid;//如果找到就记录下来
            } else
                lo = mid + 1;//没找到就扩大窗口的大小
        }
        return min;
    }

    //固定一个长度为size窗口，内部元素和是否>=s
    private boolean windowExist(int size, int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size)
                sum -= nums[i - size];
            sum += nums[i];
            if (sum >= s)
                return true;
        }
        return false;
    }
}
