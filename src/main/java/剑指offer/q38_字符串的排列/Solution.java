package 剑指offer.q38_字符串的排列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {

    @Test
    public void test() {
        String s = "abc";
        String[] strings = permutation(s);
        System.out.println(Arrays.toString(strings));
    }
    private List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        char[] strs = s.toCharArray();
        Arrays.sort(strs);
        dfs(strs, new StringBuilder(), list, new boolean[strs.length]);
        return list.toArray(new String[] {});

    }
    private void dfs(char[] strs, StringBuilder path, List<String> list, boolean[] visited) {
        if (path.length() == strs.length) {
            list.add(new String(path));
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                dfs(strs, path, list, visited);
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
