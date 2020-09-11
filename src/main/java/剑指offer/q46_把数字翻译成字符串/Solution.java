package 剑指offer.q46_把数字翻译成字符串;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        int num = 12258;
        System.out.println(translateNum(num));
    }
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1, sum = 0;
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i - 1, i + 1);
            if (t.compareTo("10") >= 0 && t.compareTo("25") <= 0) {
                sum = a + b;
            } else {
                sum = b;
            }
            a = b;
            b = sum;
        }
        return b;
    }
}
