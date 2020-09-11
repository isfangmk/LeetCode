package 剑指offer.q31_栈的压入弹出序列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int n : pushed) {
            stack.addLast(n);
            while (i < popped.length && !stack.isEmpty() && stack.getLast() == popped[i]) {
                stack.removeLast();
                i++;
            }
        }
        return i == popped.length;
    }
}
