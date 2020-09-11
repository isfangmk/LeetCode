package 剑指offer.q56_数组中数字出现的次数;

import org.junit.Test;

import java.util.Arrays;

public class SolutionII {

    @Test
    public void test() {
        int[] arr = {-3,4,-3,-3};
        System.out.println(singleNumbers(arr));
    }
    public int singleNumbers(int[] nums) {

        // 统计数组中所有数二进制位中1的出现次数。
        int[] count = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }
        // 如果某一位能被3整除，那么这一位对只出现一次的那个数的这一肯定为0。如果某一位不能被3整除，那么只出现一次的那个数字的该位置一定为1.
/*        int res = 0;
        for(int i = 0; i < 32; i++){
            res = res << 1;
            if(count[i] % 3 != 0){
                res = (res | 1);
            }
        }*/
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0) {
                res += 1<<i;
            }
        }
        return res;
    }
}
