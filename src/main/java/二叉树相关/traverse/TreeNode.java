package 二叉树相关.traverse;

import java.util.*;

public class TreeNode {
    TreeNode left, right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }
    // 中序（有序输出）
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    // 前序
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    // 后序
    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * 层次
     * O(n) time algorithm.
     * Uses O(n) space to store nodes in a queue to aid in traversal.
     */
    public void printLevelOrder(TreeNode root) {
        // 存放节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 存放结果
        List<List<Integer>> res = new ArrayList<>();
        // 根节点入队
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每一层节点的个数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                oneLevel.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(oneLevel);
        }
        System.out.println(res);
    }

    // 前序遍历的非递归写法
    public static List<Integer> preOrderUnRecur(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Deque<TreeNode> call = new LinkedList<>();    //调用栈
        call.push(root);    //先将根结点入栈
        while (!call.isEmpty()) {
            TreeNode t = call.pop();   //弹出结点并判断是否访问过
            //非空说明没访问过，然后右结点入栈，左结点入栈，最后根节点入栈，并入栈一个空结点
            //表明当前结点以访问过
            if (t != null) {
                if (t.right != null) call.push(t.right);
                if (t.left != null) call.push(t.left);
                call.push(t);
                call.push(null);
            } else {
                res.add(call.pop().data);    //如果弹出结点为空结点，表明当前栈顶结点已访问过
            }
        }
        return res;
    }
    // 中序遍历的非递归写法
    public static List<Integer> inOrderUnRecur(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Deque<TreeNode> call = new LinkedList<>();    //调用栈
        call.push(root);    //先将根结点入栈
        while (!call.isEmpty()) {
            TreeNode t = call.pop();
            if (t != null) {
                if (t.right != null) call.push(t.right);
                call.push(t);  //在左结点之前重新插入该结点，以便在左结点之后处理（访问值）
                call.push(null); //空结点随之入栈，标识已经访问过，但还没有被处理（还可以进行额外操作）
                if (t.left != null) call.push(t.left);
            } else {
                res.add(call.pop().data);
            }
        }
        return res;
    }
    // 后序遍历的非递归写法
    public static List<Integer>  postOrderUnRecur(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();  //保存结果
        Deque<TreeNode> call = new LinkedList<>();   //调用栈
        call.push(root);    //先将根结点入栈
        while (!call.isEmpty()) {
            TreeNode t = call.pop();
            if (t != null) {
                call.push(t);   //完全模拟递归，真的是秒杀全场
                call.push(null);    //！完美
                if (t.right != null) call.push(t.right);
                if (t.left != null) call.push(t.left);
            } else {
                res.add(call.pop().data);
            }
        }
        return res;
    }
}
