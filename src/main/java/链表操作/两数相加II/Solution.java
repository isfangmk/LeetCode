package 链表操作.两数相加II;

import commons.ListNode;
import commons.ListNodeUtils;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fmk
 * @date 2020/8/10 13:42
 * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 7 -> 8 -> 0 -> 7
 */
public class Solution {


    @Test
    public void test() {
        ListNode l1 = ListNodeUtils.arrayToLinkedList(new int[] {7, 2, 4 ,3});
        ListNode l2 = ListNodeUtils.arrayToLinkedList(new int[] {5, 6, 4});
        ListNodeUtils.print(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = buildStack(l1);
        Deque<Integer> stack2= buildStack(l2);
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int v1 = stack1.isEmpty() ? 0 : stack1.removeLast();
            int v2 = stack2.isEmpty() ? 0 : stack2.removeLast();
            ListNode node =  new ListNode((v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;

            // 每次都插入到dummy的后面
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    private Deque<Integer> buildStack(ListNode l) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (l != null) {
            stack.addLast(l.val);
            l = l.next;
        }
        return stack;
    }
}
