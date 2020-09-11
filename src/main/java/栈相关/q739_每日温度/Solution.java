package 栈相关.q739_每日温度;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void test() {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        nextGreaterElement(T, res);
        return res;
    }
    private void nextGreaterElement(int[] arr, int[] res) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = arr.length - 1; i >=0; i--) {
            while (!stack.isEmpty() && arr[stack.getLast()] <= arr[i]) {
                stack.removeLast();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.getLast() - i);
            stack.addLast(i);
        }
    }
}
