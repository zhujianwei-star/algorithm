package org.example.leetcode.l206;

import org.example.leetcode.ListNode;

/**
 * @description: 第L206题-反转链表
 * @question: <a href="https://leetcode-cn.com/problems/reverse-linked-list/">...</a>
 * @answer:
 */
public class L206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseList(head);
        while (newHead!= null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null ) {return head;}
        ListNode result = new ListNode();
        result.next = head;
        head=head.next;
        result.next.next = null;
        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next=result.next;
            result.next = current;
        }
        return result.next;
    }

}
