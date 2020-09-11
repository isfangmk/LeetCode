package 剑指offer.q48_最长不含重复字符的子字符串;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
