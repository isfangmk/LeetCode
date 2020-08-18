package 剑指offer.q33_二叉搜索树的后序遍历序列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fmk
 * @date 2020/8/18 6:41
 */
public class Solution2 {


    @Test
    public void test() {
        int[] arr = {1, 3, 2, 6, 5};
        System.out.println(verifyPostorder(arr));
    }
    public boolean verifyPostorder(int[] postorder) {
        // 单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        // 表示上一个根节点的元素
        int preElem = Integer.MAX_VALUE;
        // 逆序遍历
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > preElem) {
                return false;
            }
            // 一旦出现了value小于栈顶元素value的时候，就表示要开始进入左子树了
            while (!stack.isEmpty() && postorder[i] < stack.getLast()) {
                preElem = stack.removeLast();
            }
            // 往右子树遍历
            stack.addLast(postorder[i]);
        }
        return true;
    }

}
