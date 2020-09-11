package 剑指offer.q6_从尾到头打印链表;


import commons.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {


    private List<Integer> tmp = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int size = tmp.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = tmp.get(i);
        }
        return res;

    }
    private void recur(ListNode haed) {
        if (haed == null) return;
        recur(haed.next);
        tmp.add(haed.val);
    }
}
