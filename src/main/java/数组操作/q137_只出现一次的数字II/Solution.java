package 数组操作.q137_只出现一次的数字II;

import org.junit.Test;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
 * 找出那个只出现了一次的元素。
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class Solution {

    @Test
    public void test() {
        int[] arr = {3, 5, 3, 3};
        System.out.println(singleNumber(arr));
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) // 统计1的次数
                    count++;
            }
            res ^= (count % 3) << i;
        }
        return res;

    }
}
