package org.example.leetcode.l155;

import java.util.Objects;
import java.util.Stack;

/**
 * @description: 第L155题：最小栈
 * @question: <a href="https://leetcode-cn.com/problems/min-stack">...</a>
 * @answer: 需要使用O(1)的方式获取栈内的最小元素，可以使用两个栈，一个栈存放元素，一个栈存放最小元素。
 *          入栈时，将元素压入栈1，同时判断栈2是否为空，若为空，则压入栈2；若不为空，则比较栈2的栈顶元素与当前元素的大小，若当前元素小于栈2的栈顶元素，则压入栈2；否则，不压入栈2。
 *          出栈时，判断栈1是否为空，若为空，则栈2出栈；若不为空，则栈1出栈。
 */
public class L155 {

    static class MinStack {

        Stack<Integer> stack;

        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            if (Objects.equals(minStack.peek(), pop)) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
