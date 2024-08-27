package org.example.leetcode.l142;

import org.example.leetcode.ListNode;

/**
 * @description: 第L142题-环形链表II
 * @question: <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">...</a>
 * @answer:
 */
public class L142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode node = detectCycle(head);
        System.out.println(node.val);
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}