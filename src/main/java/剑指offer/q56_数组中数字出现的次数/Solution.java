package 剑指offer.q56_数组中数字出现的次数;

import org.junit.Test;

import java.util.Arrays;

public class Solution {


    @Test
    public void test() {
        int[] arr = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers(arr)));
    }
    public int[] singleNumbers(int[] nums) {
        int orRes = 0;
        for (int n : nums) {
            orRes ^= n;
        }
        // 找到orRes的第几位是1
        /*
        int temp = 1;
        while (true) {
            if ((orRes & 1) == 1) {
                break;
            }
            temp  = temp << 1;
            orRes = orRes >> 1;
        }
        */
        int temp = (-orRes) & orRes;
        int[] res = new int[2];
        for (int n : nums) {
            if ((temp & n) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}
