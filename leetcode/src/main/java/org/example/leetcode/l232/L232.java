package org.example.leetcode.l232;

import java.util.Stack;

/**
 * @description: 第L232题-用栈实现队列
 * @question: <a href="https://leetcode-cn.com/problems/implement-queue-using-stacks/">...</a>
 * @answer: 使用两个栈，一个用作进入数据时的栈即为入数栈，一个用作获取数据时的栈即为出数栈，
 * 如果出数栈为空，就需要循环获取入数栈的数据，知道将入数栈的所有数据获取到出数栈中，然后返回出数栈的最上面一个元素，就可以实现先进先出的功能
 */
public class L232 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek()); // 1
        System.out.println(queue.pop()); // 1
        System.out.println(queue.peek()); // 2
        System.out.println(queue.pop()); // 2
        System.out.println(queue.pop()); // 3
        System.out.println(queue.pop()); // null
    }

    static class MyQueue {

        Stack<Integer> enterStack;

        Stack<Integer> outerStack;

        public MyQueue() {
            enterStack = new Stack<>();
            outerStack = new Stack<>();
        }

        public void push(int x) {
            enterStack.push(x);
        }

        public int pop() {
            if (outerStack.isEmpty()) {
                if (enterStack.isEmpty()) {
                    return 0;
                }
                while (!enterStack.isEmpty()) {
                    outerStack.push(enterStack.pop());
                }
            }
            return outerStack.pop();
        }

        public int peek() {
            if (outerStack.isEmpty()) {
                if (enterStack.isEmpty()) {
                    return 0;
                }
                while (!enterStack.isEmpty()) {
                    outerStack.push(enterStack.pop());
                }
            }
            return outerStack.peek();
        }

        public boolean empty() {
            return outerStack.isEmpty() && enterStack.isEmpty();
        }
    }

}
