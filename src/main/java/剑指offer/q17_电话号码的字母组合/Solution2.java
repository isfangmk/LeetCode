package 剑指offer.q17_电话号码的字母组合;

import org.junit.Test;

import java.util.*;

public class Solution2 {


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
        // BFS
        Deque<String> queue = new LinkedList<>();
        bfs(queue, map, digits);
        res.addAll(queue);
        return res;
    }
    private void bfs(Deque<String> queue, Map<Character, String> map, String digits) {

        queue.addFirst("");
        for (int i = 0; i < digits.length(); i++) {
            int count = queue.size();
            for (int j = 0; j < count; j++) {
                String t = queue.removeFirst();
                String letters = map.get(digits.charAt(i));
                for (int k = 0; k < letters.length(); k++) {
                    queue.addLast(t + letters.charAt(k));
                }
            }
        }
    }

}
