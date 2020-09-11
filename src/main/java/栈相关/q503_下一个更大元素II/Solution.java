package 栈相关.q503_下一个更大元素II;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void test() {
        int[] arr = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 2 * n  - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.getLast() <= nums[i % n]) {
                stack.removeLast();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.getLast();
            stack.addLast(nums[i % n]);
        }
        return res;
    }
}
