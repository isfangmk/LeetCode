package 数据结构;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {


    private Deque<Integer> data  = new ArrayDeque<>();
    // 在队尾添加元素n
    public void push(int n) {
        while (!data.isEmpty() && data.getLast() < n) {
            data.removeLast();
        }
        data.addLast(n);
    }
    // 获取队列中的最大值
    public int max() {
        return data.getFirst();
    }
    // 在对头删除元素n
    public void pop(int n) {
        if (!data.isEmpty() && data.getFirst() == n) {
            data.removeFirst();
        }
    }
}
