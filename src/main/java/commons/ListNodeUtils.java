package commons;

import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 13:28
 */
public class ListNodeUtils {


    @Test
    public void test() {
        ListNode head = arrayToLinkedList(new int[] {1, 2, 3});
        print(head);
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length < 1) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void print(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.val + "->");
            } else {
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
    }
}
