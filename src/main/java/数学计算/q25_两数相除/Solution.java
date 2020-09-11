package 数学计算.q25_两数相除;

import org.junit.Test;

public class Solution {


    @Test
    public void test() {
        System.out.println(divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;

        long m = Math.abs((long) dividend), n = Math.abs((long) divisor), res = 0;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return (int) (sign == 1 ? res : -res);
    }
}
