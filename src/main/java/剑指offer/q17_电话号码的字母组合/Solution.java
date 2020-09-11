package 剑指offer.q17_电话号码的字母组合;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(res, new StringBuilder(), map, digits, 0);
        return res;
    }
    private void dfs(List<String> res, StringBuilder path, Map<Character, String> map, String digits, int index) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(res, path, map, digits, index+1);
            path.deleteCharAt(index);
        }
    }

}
