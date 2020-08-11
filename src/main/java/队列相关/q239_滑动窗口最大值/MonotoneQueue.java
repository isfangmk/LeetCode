package 队列相关.q239_滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fmk
 * @date 2020/8/10 8:24
 */
public class MonotoneQueue {


    private Deque<Integer> data  = new ArrayDeque<>();
    public void push(int n) {
        while (!data.isEmpty() && data.getLast() < n) {
            data.removeLast();
        }
        data.addLast(n);
    }
    public int max() {
        return data.getFirst();
    }
    public void pop(int n) {
        if (!data.isEmpty() && data.getFirst() == n) {
            data.removeFirst();
        }
    }

}
