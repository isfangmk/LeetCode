package 栈相关.q150_逆波兰表达式求值;

import org.junit.Test;

import java.util.*;
public class Solution {

    @Test
    public void test() {
        String[] arr = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(arr));
    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        Set<String> opts = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (!opts.contains(token)) {
                deque.addLast(Integer.parseInt(token));
            } else {
                int a = deque.removeLast();
                int b = deque.removeLast();
                switch (token) {
                    case "+":
                        deque.addLast(b + a);
                        break;
                    case "-":
                        deque.addLast(b - a);
                        break;
                    case "*":
                        deque.addLast(b * a);
                        break;
                    case "/":
                        deque.addLast(b / a);
                        break;
                }
            }
        }
        return deque.removeFirst();
    }
}
