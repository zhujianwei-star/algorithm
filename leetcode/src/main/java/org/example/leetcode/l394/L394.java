package org.example.leetcode.l394;

import java.util.Stack;

/**
 * @description: 第L394题-字符串解码
 * @question: <a href="https://leetcode-cn.com/problems/decode-string">...</a>
 * @answer: 主要是遇到了"]" 该字符串的处理，首先，需要获取到所有在栈中的的字母的字符串，然后拼接，拼接时需要注意顺序，然后再删除掉 "[" 字符串，
 * 然后获取数字的字符串，然后反转该字符串，然后循环拼接字符串，比如 2[a2[bc]]，这种情况下我们可以先转化成 2[abcbc]，在转化成 abcbcabcbc。
 */
public class L394 {

    public static void main(String[] args) {
        // String s = "3[a]2[bc]";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString(s));
    }


    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ("]".equalsIgnoreCase(String.valueOf(s.charAt(i)))) {
                if (stack.isEmpty()) {
                    return "";
                }
                String peek = stack.peek();
                StringBuilder subSB = new StringBuilder();
                while (!"[".equalsIgnoreCase(peek)) {
                    String pop = stack.pop();
                    if (stack.isEmpty()) {
                        return "";
                    }
                    subSB = new StringBuilder(pop).append(subSB);
                    peek = stack.peek();
                }
                String originalStr = subSB.toString();

                // 此时pop的值为 "["
                stack.pop();

                StringBuilder numSB = new StringBuilder();
                String numPeek = stack.peek();
                while (numPeek.chars().allMatch(Character::isDigit)) {
                    String numPop = stack.pop();
                    numSB.append(numPop);
                    if (stack.isEmpty()) {
                        break;
                    }
                    numPeek = stack.peek();
                }
                numSB.reverse();

                int strNum = Integer.parseInt(String.valueOf(numSB));

                StringBuilder newSubSB = new StringBuilder();
                for (int i1 = 0; i1 < strNum; i1++) {
                    newSubSB.append(originalStr);
                }

                stack.push(newSubSB.toString());
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder = new StringBuilder(stack.pop()).append(stringBuilder);
        }
        return stringBuilder.toString();
    }

}
