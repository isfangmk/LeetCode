package 二叉树相关.q98_验证二叉搜索树;

import commons.TreeNode;

public class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) return false;
            if (pre >= root.val) return false;
            pre = root.val;
            if (!isValidBST(root.right)) return false;
        }
        return true;
    }
}
