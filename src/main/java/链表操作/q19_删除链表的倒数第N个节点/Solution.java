package 链表操作.q19_删除链表的倒数第N个节点;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 14:56
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Solution {

    @Test
    public void test() {
        ListNode head = ListNodeUtils.arrayToLinkedList(new int[] {1, 2, 3, 4 ,5});
        ListNodeUtils.print(removeNthFromEnd(head, 5));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        // 快指针先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        // 快慢指针一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时slow停在要删除节点的前一个节点
        slow.next = slow.next.next;
        return head;
    }
}
