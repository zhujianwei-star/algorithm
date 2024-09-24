package org.example.leetcode.l946;

import java.util.Stack;

/**
 * @description: 第L946题-验证栈序列
 * @question: <a href="https://leetcode-cn.com/problems/validate-stack-sequences/">...</a>
 * @answer:
 */
public class L946 {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4,3,5,1,2};
        // int[] popped = {4, 5, 3, 2, 1};
        boolean result = validateStackSequences(pushed, popped);
        System.out.println(result);
    }

    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟入栈与出栈，如果遇到和popped数相同就出栈，没有的话就继续入栈，如果到最后还没有，就直接返回false
        Stack<Integer> stack = new Stack<>();
        int pop = 0;
        for (int j : pushed) {
            stack.push(j);
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        if (pop == popped.length) {
            return true;
        }
        return false;
    }

}
