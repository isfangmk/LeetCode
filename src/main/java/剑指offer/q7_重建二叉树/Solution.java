package 剑指offer.q7_重建二叉树;



import commons.TreeNode;

import java.util.*;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 存储中序遍历的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        po = preorder;
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param pre_root 根节点在前序遍历中的索引
     * @param in_left 中序遍历的左边界
     * @param in_right 中序遍历的右边界
     * @return 根节点
     */
    private TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) return null;
        int rootVal = po[pre_root];

        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在中序遍历中的位置
        int i = map.get(rootVal);
        // pre_root + 1 左子树在先序遍历中的位置
        root.left = recur(pre_root + 1, in_left, i - 1);
        // pre_root + i - in_left + 1 右子树在先序遍历中的位置 （根节点索引 + 左子树节点个数）
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;

    }
}
