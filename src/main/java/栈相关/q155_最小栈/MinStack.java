package 栈相关.q155_最小栈;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {


    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    public MinStack() {

    }

    public void push(int x) {
        stack1.addLast(x);
        if (stack2.isEmpty() || x <= stack2.getLast()) {
            stack2.addLast(x);
        }
    }

    public void pop() {
        int data = stack1.removeLast();
        if (data == stack2.getLast()) {
            stack2.removeLast();
        }
    }

    public int top() {
        return stack1.getLast();
    }

    public int getMin() {
        return stack2.getLast();
    }
}

