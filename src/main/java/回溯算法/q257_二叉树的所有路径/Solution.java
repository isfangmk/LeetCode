package 回溯算法.q257_二叉树的所有路径;

import commons.TreeNode;

import java.util.*;
public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, new StringBuilder());
        return res;
    }
    private void dfs(TreeNode root, StringBuilder path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(path.toString() + root.val);
            return;
        }
        int curLen = path.length();
        path.append(root.val).append("->");
        dfs(root.left, path);
        dfs(root.right, path);
        path.delete(curLen, path.length());

    }
}
