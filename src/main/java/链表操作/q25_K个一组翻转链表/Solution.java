package 链表操作.q25_K个一组翻转链表;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 19:11
 */
public class Solution {

    @Test
    public void test() {
        ListNode head = ListNodeUtils.arrayToLinkedList(new int[] {1, 2, 3, 4, 5});
        ListNodeUtils.print(reverseKGroup(head, 2));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        int num = 1;
        // 节点p走到最后一个节点
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            num++;
        }
        ListNode temp = null;
        int l = 1, count = 1;
        while (true) {
            int r = k * count;
            if (r <= num) {
                temp = reverseBetween(head, l, r);
                head = temp;
                l = r + 1;
                count++;
            } else {
                break;
            }
        }
        return head;
    }
    // 迭代局部反转链表
    public ListNode reverseBetween(ListNode head, int m, int n) {

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
}
