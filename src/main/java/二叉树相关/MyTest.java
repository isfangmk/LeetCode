package 二叉树相关;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(Arrays.toString(threeOrders(treeNode)));
    }

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {

        // write code here
        ArrayList<Integer> preList = new ArrayList<>();
        preOrder(root, preList);
        int nodeSize = preList.size();
        int[][] res = new int[3][nodeSize];

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            if (i == 0) {
                list = preList;
            }
            if (i == 1) {
                inOrder(root, list);
            }
            if (i == 2) {
                postOrder(root, list);
            }
            for (int j = 0; j < list.size(); j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;
    }
    //前序遍历
    public void preOrder(TreeNode root,ArrayList<Integer> qian){
        if(root== null)
            return;
        //System.out.println(root.val);
        qian.add(root.val);
        preOrder(root.left,qian);
        preOrder(root.right,qian);
    }

    //中序遍历
    public void inOrder(TreeNode root,ArrayList<Integer> zhong){
        if(root==null){
            return;
        }
        inOrder(root.left,zhong);
        zhong.add(root.val);
        //System.out.println(root.val);
        inOrder(root.right,zhong);

    }

    //后序遍历
    public void postOrder(TreeNode root,ArrayList<Integer> Hou){
        if(root==null)
            return;
        postOrder(root.left,Hou);
        postOrder(root.right,Hou);
        Hou.add(root.val);
        //System.out.println(root.val);
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
