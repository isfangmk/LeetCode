package 链表操作.q2_两数相加;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 13:17
 *
 * (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 7 -> 0 -> 8
 * 342 + 465 = 807
 */
public class Solution {


    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.arrayToLinkedList(new int[] {2, 4, 3});
        ListNode l2 = ListNodeUtils.arrayToLinkedList(new int[] {5, 6, 6});
        ListNodeUtils.print(addTwoNumbers(l1, l2));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
