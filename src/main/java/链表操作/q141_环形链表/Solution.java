package 链表操作.q141_环形链表;

import commons.ListNode;
import org.junit.Test;

import java.util.List;

public class Solution {

    @Test
    public void test() {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println("是否有环：" + hasCycle(node1));
        System.out.println("若存在环，环的长度是：" + cycleLength(node1));
        System.out.println("若存在环，入环点是：" + entrance(node1).val);
    }
    // 判断是否有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;

    }
    // 如果有环，求环的长度
    // 当两个指针首次相遇，证明链表有环的时候，慢指针继续前进，
    // 并统计前进的循环次数，直到两个指针第2次相遇。 此时，统计出来的前进次数就是环长。
    public int cycleLength(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (fast != null || fast.next != null) return 0;
        int count = 0;
        do {
            fast = fast.next;
            count++;
        } while (fast != slow);
        return count;
    }
    //如果有环，求入环点
    //把其中一个指针放回到头节点位置，另一个指针保持在首次相遇点，
    // 两个指针都是每次向前走1步。 那么，它们最终相遇的节点，就是入环节点。
    public ListNode entrance(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (fast != null || fast.next != null) return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
