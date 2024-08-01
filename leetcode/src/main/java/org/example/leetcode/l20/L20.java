package org.example.leetcode.l20;

import java.util.Objects;
import java.util.Stack;

/**
 * @description: 第L20题-有效的括号
 * @question: <a href="https://leetcode-cn.com/problems/valid-parentheses/">...</a>
 * @answer:
 */
public class L20 {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char currentCharacter = s.charAt(i);
            if (Objects.equals('(', currentCharacter)
                    || Objects.equals('[', currentCharacter)
                    || Objects.equals('{', currentCharacter)) {
                stack.push(currentCharacter);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (Objects.equals(')', currentCharacter)) {
                    if (!Objects.equals('(', stack.pop())) {
                        return false;
                    }
                }
                if (Objects.equals(']', currentCharacter)) {
                    if (!Objects.equals('[', stack.pop())) {
                        return false;
                    }
                }
                if (Objects.equals('}', currentCharacter)) {
                    if (!Objects.equals('{', stack.pop())) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
