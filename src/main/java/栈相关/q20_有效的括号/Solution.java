package 栈相关.q20_有效的括号;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    @Test
    public void test() {
        System.out.println(isValid("([]){}"));
    }
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.getLast()) {
                    return false;
                } else {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
