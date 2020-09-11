package 剑指offer.q14_剪绳子I;

import org.junit.Test;

/**
 *  状态定义：dp[i]表示长度为i的绳子的最大乘积值(也就表示了肯定至少切割过一次)
 * 切割点为j，j遍历1到i
 * 则有转移方程 dp[i] = max(j段绳子最大值*剩下i-j段绳子最大值)
 * 其中j段绳子最大值可以分为切还是不切：max(j,dp[j])
 * 同理有剩下i-j段绳子最大值：max(i-j,dp[i-j])
 */
public class Solution2 {


    @Test
    public void test() {
        System.out.println(cuttingRope(10));
    }
    public int cuttingRope(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;
        // dp[i]至少切割过一次
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }


}
