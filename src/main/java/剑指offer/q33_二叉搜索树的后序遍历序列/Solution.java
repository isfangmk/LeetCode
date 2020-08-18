package 剑指offer.q33_二叉搜索树的后序遍历序列;

/**
 * @author fmk
 * @date 2020/8/18 6:41
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int rootValue = postorder[right];
        // 找到第一个大于rootValue的节点，将树拆分为左右子树
        int k = left;
        while (k < right && postorder[k] < rootValue) {
            k++;
        }
        // 此时k的前面都是小于rootValue的数，需要验证k的后面是否都大于rootValue
        for (int i = k; i < right; i++) {
            if (postorder[i] < rootValue) return false;
        }
        return recur(postorder, left, k - 1) && recur(postorder, k, right - 1);
    }
}
