package org.example.leetcode.l160;

import org.example.leetcode.ListNode;

import java.util.List;

/**
 * @description: 第L160题-相交链表
 * @question: <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">...</a>
 * @answer:
 */
public class L160 {

    public static void main(String[] args) {
        int intersectVal = 8;
        ListNode headA = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5))))));
        int skipA = 2;
        int skipB = 3;

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println(result.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
