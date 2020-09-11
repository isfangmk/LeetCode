package hash相关.q560_和为K的子数组;

import org.junit.Test;

public class Solution {


    @Test
    public void test() {
        int[] arr = {1, -1, 1, -1, 1};
        System.out.println(subarraySum(arr, 0));
    }


    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和
        int[] prefixSum = new int[len + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] +nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (prefixSum[right + 1] - prefixSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
