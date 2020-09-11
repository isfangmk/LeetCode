package 剑指offer.q14_剪绳子I;

/**
 *  f(x)=(n/x)^x 求极值，(n/x)=e时取最大值
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        return f(n);
    }
    int f(int n) {
        if (n <= 4) return n;
        return f(n - 3) * 3;
    }

}
