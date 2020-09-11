package 剑指offer.q41_数据流中的中位数;

import java.util.PriorityQueue;

public class Solution {


    // 大顶堆，保存较小的一半
    PriorityQueue<Integer> A = new PriorityQueue<>((n1, n2) -> n2 - n1);
    // 小顶堆，保存较大的一半，维持heap1.size - heap2.size() >= 1
    PriorityQueue<Integer> B = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (B.size() != A.size()) {
            B.add(num);
            // 将B中最小的数，添加到A中
            A.add(B.poll());
        } else {
            A.add(num);
            // 将A最大的数，添加到B中
            B.add(A.poll());
        }
    }

    public Double GetMedian() {
        return B.size() != A.size() ? (double) B.peek() : (B.peek() + A.peek()) / 2.0;
    }
}
