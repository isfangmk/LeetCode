package 二叉树相关.traverse;

import java.util.*;

public class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }
    // 中序（有序输出）
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }
    // 前序
    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }
    // 后序
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(data + " ");
    }

    /**
     * 层次
     * O(n) time algorithm.
     * Uses O(n) space to store nodes in a queue to aid in traversal.
     */
    public void printLevelOrder() {
        // 存放节点
        Queue<Node> queue = new ArrayDeque<>();
        // 存放结果
        List<List<Integer>> res = new ArrayList<>();
        // 根节点入队
        queue.add(this);
        while (queue.size() > 0) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每一层节点的个数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.remove();
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
    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {

                head = stack.pop();
                System.out.print(head.data + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }
    // 中序遍历的非递归写法
    public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.data + " ");
                    head = head.right;
                }
            }
        }
    }
    // 后序遍历的非递归写法
    public static void postOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                // 跟节点存入s2中
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().data + " ");
            }
        }
    }
}
