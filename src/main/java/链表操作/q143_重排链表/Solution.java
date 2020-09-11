package 链表操作.q143_重排链表;

import commons.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverse(newHead);

        //链表节点依次连接
        ListNode cur = head;
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = cur.next;
            cur.next = newHead;
            cur = newHead.next;
            newHead = temp;
        }

    }
    private ListNode reverse(ListNode head) {
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
}
