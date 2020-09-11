package 剑指offer.q56_和为s的连续正数序列;

import org.junit.Test;

import java.util.*;

public class Solution {

    @Test
    public void test() {
        List<int[]> list = findContinuousSequence(15);
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public List<int[]> findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res;
    }

}
