package 栈相关.q496_下一个更大元素I;

import org.junit.Test;

import java.util.*;

public class Solution {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = nextGreaterElement(nums2);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private Map<Integer, Integer> nextGreaterElement(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = arr.length - 1; i >=0; i--) {
            while (!stack.isEmpty() && stack.getLast() <= arr[i]) {
                stack.removeLast();
            }
            map.put(arr[i], stack.isEmpty() ? - 1 : stack.getLast());
            stack.addLast(arr[i]);
        }
        return map;
    }
}
