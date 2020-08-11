package hash相关.q387_字符串中的第一个唯一字符;

/**
 * @author fmk
 * @date 2020/8/9 19:56
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
