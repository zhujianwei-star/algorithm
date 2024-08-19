package org.example.leetcode.l876;

import org.example.leetcode.ListNode;

/**
 * @description: 第L876题-链表的中间结点
 * @question: <a href="https://leetcode-cn.com/problems/middle-of-the-linked-list/">...</a>
 * @answer:
 */
public class L876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode middle = middleNode(head);
        System.out.println(middle.val);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode front = head;
        ListNode later = head;
        while (front != null && front.next != null) {
            front = front.next.next;
            later = later.next;
        }
        return later;
    }
}
