package 回溯算法.q46_全排列;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                // 回溯
                dfs(nums, len, depth + 1, path, used, res);
                // 撤销选择
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
