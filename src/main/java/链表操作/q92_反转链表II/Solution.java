package 链表操作.q92_反转链表II;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 15:30
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1->2->3->4->5->NULL, m = 2, n = 4
 * 1->4->3->2->5->NULL
 */
public class Solution {


    // 测试局部反转链表
    @Test
    public void test2() {
        ListNode node = reverseBetween1(ListNodeUtils.arrayToLinkedList(
                new int[] {1, 2, 3, 4, 5}
        ), 2, 4);
        ListNodeUtils.print(node);
    }

    // 迭代反转局部链表
    public ListNode reverseBetween1(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // g走到第m个节点的前一个位置
        // p走到第m个节点的位置
        ListNode g = dummy;
        ListNode p = g.next;
        for (int i = 0; i < m-1; i++) {
            g = g.next;
            p = p.next;
        }
        // 将p后面的节点删除，每次都添加到g的后面
        for (int i = 0; i < n - m; i++) {
            ListNode node = p.next;
            p.next = p.next.next;

            node.next = g.next;
            g.next = node;
        }
        return dummy.next;

    }


    // 测试反转链表的前n个节点
    @Test
    public void test1() {
        ListNode node = reverseN1(ListNodeUtils.arrayToLinkedList(
                new int[] {1, 2}
        ), 1);
        ListNodeUtils.print(node);
    }

    // 迭代：反转前n个
    public ListNode reverseN1(ListNode head, int n) {

        ListNode p = head;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }
        ListNode cur = head;
        while (cur != p) {
            ListNode next = cur.next;
            cur.next = p.next;
            p.next = cur;

            cur = next;
        }
        return p;
    }


    // 递归反转局部链表
    ListNode successor = null; // 后驱节点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) reverseN(head, n);
        head.next = reverseBetween(head, m - 1, n - 1);
        return head;
    }


    // 递归:反转前n个
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode node = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return node;

    }
}
