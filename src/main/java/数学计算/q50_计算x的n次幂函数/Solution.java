package 数学计算.q50_计算x的n次幂函数;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/11 12:20
 * 2.00000, 10   1024.00000
 *2.00000, -2 0.25000
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(myPow(2.1, 9));
    }
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            // 奇数
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            // 整除2
            b >>= 1;
        }
        return res;

    }
}
