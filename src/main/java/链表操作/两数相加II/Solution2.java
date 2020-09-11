package 链表操作.两数相加II;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fmk
 * @date 2020/8/10 13:42
 * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 7 -> 8 -> 0 -> 7
 */
public class Solution2 {


    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.arrayToLinkedList(new int[] {7, 2, 4 ,3});
        ListNode l2 = ListNodeUtils.arrayToLinkedList(new int[] {5, 6, 4});
        ListNodeUtils.print(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        head1 = reverse(head1);
        head2 = reverse(head2);

        while (head1 != null || head2 != null || carry == 1) {
            int v1 = head1 == null ? 0 : head1.val;
            int v2 = head2 == null ? 0 : head2.val;
            int sum = v1 + v2 + carry;
            ListNode node =  new ListNode(sum % 10);
            carry = sum / 10;
            node.next = dummy.next;
            dummy.next = node;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        return dummy.next;

    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
