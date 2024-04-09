package com.exampel.linkedList;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName : ReverseList
 * @Description: 反转链表
 * @Author : Zhujw
 * @CreateDate : 2022/3/3 20:32
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(9);
        System.out.println(officialSolution(head));
    }

    private static ListNode solution(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) return null;
        ListNode pop = stack.pop();
        ListNode res = pop;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            pop.next = tempNode;
            pop = pop.next;
        }
        pop.next = null;
        return res;
    }

    private static ListNode officialSolution(ListNode head) {
        ListNode result = null;

        while (head != null) {

            ListNode temp = head.next;


            head.next = result;

            result = head;

            head = temp;

        }
        return result;
    }
}
