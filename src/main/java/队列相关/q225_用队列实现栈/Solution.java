package 队列相关.q225_用队列实现栈;

import java.util.*;
public class Solution {

}
class MyStack {
    private Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i ++) {
            queue.addLast(queue.removeFirst());
        }
        return queue.removeFirst();

    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < queue.size() - 1; i ++) {
            queue.addLast(queue.removeFirst());
        }
        int data =  queue.getFirst();
        queue.addLast(queue.removeFirst());
        return data;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
