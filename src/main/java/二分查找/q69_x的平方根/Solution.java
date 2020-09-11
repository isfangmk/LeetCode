package 二分查找.q69_x的平方根;

import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        System.out.println(sqrt(9));
        System.out.println(sqrt(2));
        System.out.println(sqrt(5));
        System.out.println(sqrt(15));
        System.out.println(sqrt(16));
    }

    public int sqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x / 2;

        while (l < h) {
            int m = (l + h) >>> 1;
            int t = x / m;
            if (t == m) return m;
            else if (t > m) l = m + 1;
            else h = m - 1;
        }
        return l * l > x ? l - 1 : l;
    }
}
