package 链表操作.q206_反转链表;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 15:18
 * 1->2->3->4->5->NULL
 * 5->4->3->2->1->NULL
 */
public class Solution {


    @Test
    public void test() {
        ListNode node = reverseList2(ListNodeUtils.arrayToLinkedList(
                new int[] {1, 2, 3 ,4, 5}
        ));
        ListNodeUtils.print(node);
    }

    // 方法2：迭代
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    // 方法1：递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
