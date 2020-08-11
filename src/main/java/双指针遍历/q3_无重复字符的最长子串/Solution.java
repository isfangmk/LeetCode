package 双指针遍历.q3_无重复字符的最长子串;

import java.util.HashSet;

/**
 * @author fmk
 * @date 2020/8/10 8:01
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, right = 0, left = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(set.size(), res);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }
}
